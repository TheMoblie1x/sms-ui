package com.example.sms_mui_compose.ui.theme.activity.activity

import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import java.io.File

@Composable
fun FileUploadQuestion(
    questionId: String,
    questionText: String,
    allowedMimeTypes: List<String>,
    maxFileSizeMB: Int,
    uploadFileToServer: suspend (File) -> Boolean,
    onAnswerChanged: (questionId: String, file: File?) -> Unit,
    errorMessages: FileUploadErrors = FileUploadErrors(),
    allowDownload: Boolean = true
) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    var file by remember { mutableStateOf<File?>(null) }
    var error by remember { mutableStateOf<String?>(null) }
    var uploading by remember { mutableStateOf(false) }
    var uploadSuccess by remember { mutableStateOf<Boolean?>(null) }

    val fileLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let {
            val mimeType = context.contentResolver.getType(uri)
            val fileSizeBytes = context.contentResolver.openInputStream(uri)?.available()?.toDouble() ?: 0.0
            val fileSizeMB = fileSizeBytes / (1024 * 1024)

            when {
                mimeType == null || !allowedMimeTypes.contains(mimeType) -> {
                    error = errorMessages.invalidType
                    file = null
                    uploadSuccess = null
                    onAnswerChanged(questionId, null)
                }

                fileSizeMB > maxFileSizeMB -> {
                    error = errorMessages.fileTooLarge.replace("{size}", maxFileSizeMB.toString())
                    file = null
                    uploadSuccess = null
                    onAnswerChanged(questionId, null)
                }

                else -> {
                    file = copyUriToFile(context, uri)
                    error = null
                    uploading = true
                    uploadSuccess = null

                    coroutineScope.launch {
                        val success = uploadFileToServer(file!!)
                        uploading = false
                        uploadSuccess = success
                        onAnswerChanged(questionId, if (success) file else null)
                    }
                }
            }
        }
    }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = questionText, style = MaterialTheme.typography.bodySmall)

        Spacer(modifier = Modifier.height(8.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Button(onClick = { fileLauncher.launch("*/*") }) {
                Text(if (file == null) "Upload File" else "Replace File")
            }

            if (allowDownload && file != null && uploadSuccess == true) {
                Spacer(modifier = Modifier.width(12.dp))
                IconButton(onClick = {
                    Toast.makeText(context, "Pretend we're downloading ${file!!.name}", Toast.LENGTH_SHORT).show()
                }) {
                    Icon(Icons.Default.KeyboardArrowDown, contentDescription = "Download File")
                }
            }
        }

        file?.name?.let {
            Spacer(modifier = Modifier.height(8.dp))
            Text("Selected: $it", style = MaterialTheme.typography.bodySmall)
        }

        error?.let {
            Spacer(modifier = Modifier.height(8.dp))
            Text(it, color = Color.Red, style = MaterialTheme.typography.bodySmall)
        }

        if (uploading) {
            Spacer(modifier = Modifier.height(8.dp))
            LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
        }

        uploadSuccess?.let {
            Spacer(modifier = Modifier.height(8.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = if (it) "Upload successful ✅" else "Upload failed ❌",
                    color = if (it) Color(0xFF4CAF50) else Color.Red,
                    style = MaterialTheme.typography.bodySmall
                )

                if (!it) {
                    Spacer(modifier = Modifier.width(8.dp))
                    TextButton(onClick = {
                        // Retry
                        file?.let { selectedFile ->
                            coroutineScope.launch {
                                uploading = true
                                val success = uploadFileToServer(selectedFile)
                                uploading = false
                                uploadSuccess = success
                                error = null
                                onAnswerChanged(questionId, if (success) selectedFile else null)
                            }
                        }
                    }) {
                        Text("Retry")
                    }
                }
            }
        }
    }
}

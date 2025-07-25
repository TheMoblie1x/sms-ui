package com.example.sms_mui_compose.ui.theme.activity.activity

import android.content.Context
import android.net.Uri
import android.provider.OpenableColumns
import java.io.File
import java.io.FileOutputStream

data class FileUploadErrors(
    val invalidType: String = "Unsupported file type.",
    val fileTooLarge: String = "File exceeds {size}MB limit."
)


fun getFileName(context: Context, uri: Uri): String {
    var name = "unknown"
    val cursor = context.contentResolver.query(uri, null, null, null, null)
    cursor?.use {
        val index = it.getColumnIndex(OpenableColumns.DISPLAY_NAME)
        if (it.moveToFirst()) name = it.getString(index)
    }
    return name
}

fun copyUriToFile(context: Context, uri: Uri): File {
    val fileName = getFileName(context, uri)
    val file = File(context.cacheDir, fileName)
    context.contentResolver.openInputStream(uri)?.use { input ->
        FileOutputStream(file).use { output ->
            input.copyTo(output)
        }
    }
    return file
}

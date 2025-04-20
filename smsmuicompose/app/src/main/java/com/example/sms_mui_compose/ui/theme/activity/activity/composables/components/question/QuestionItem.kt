package com.example.sms_mui_compose.ui.theme.activity.activity.composables.components.question

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.sms_mui_compose.ui.theme.activity.activity.enums.AnswerType

@Composable
fun QuestionItem(
    questionTitle: String,
    description: String,
    answerType: AnswerType,
    answerList: List<String>,
    selectedAnswer: String,
    onAnswerSelected: (String) -> Unit
) {
    var textAnswer by remember { mutableStateOf(selectedAnswer) }
    val selectedOptions = remember { mutableStateListOf<String>() }

    // Initialize selectedOptions from selectedAnswer for MultipleChoice
    if (answerType == AnswerType.MultipleChoice && selectedAnswer.isNotEmpty()) {
        remember {
            selectedOptions.addAll(selectedAnswer.split(", "))
            true // Trigger recomposition only once
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .border(1.dp, MaterialTheme.colorScheme.primary, shape = MaterialTheme.shapes.medium)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = questionTitle, style = MaterialTheme.typography.titleLarge)
            Text(text = description, style = MaterialTheme.typography.bodyMedium)
            Text(text = "Answer Type: $answerType", style = MaterialTheme.typography.bodySmall)

            Spacer(modifier = Modifier.height(8.dp))

            when (answerType) {
                AnswerType.SingleChoice -> {
                    answerList.forEach { answer ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    onAnswerSelected(answer)
                                    textAnswer = answer
                                }
                                .padding(vertical = 4.dp)
                        ) {
                            RadioButton(
                                selected = answer == textAnswer,
                                onClick = {
                                    onAnswerSelected(answer)
                                    textAnswer = answer
                                }
                            )
                            Text(text = answer, modifier = Modifier.padding(start = 8.dp))
                        }
                    }
                }

                AnswerType.MultipleChoice -> {
                    answerList.forEach { answer ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    if (selectedOptions.contains(answer)) {
                                        selectedOptions.remove(answer)
                                    } else {
                                        selectedOptions.add(answer)
                                    }
                                    onAnswerSelected(selectedOptions.joinToString(", "))
                                }
                                .padding(vertical = 4.dp)
                        ) {
                            Checkbox(
                                checked = selectedOptions.contains(answer),
                                onCheckedChange = { isChecked ->
                                    if (isChecked) selectedOptions.add(answer)
                                    else selectedOptions.remove(answer)
                                    onAnswerSelected(selectedOptions.joinToString(", "))
                                }
                            )
                            Text(text = answer, modifier = Modifier.padding(start = 8.dp))
                        }
                    }
                }

                AnswerType.SmallText, AnswerType.LargeText -> {
                    OutlinedTextField(
                        value = textAnswer,
                        onValueChange = {
                            textAnswer = it
                            onAnswerSelected(it)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(if (answerType == AnswerType.LargeText) 160.dp else 56.dp),
                        label = { Text("Your answer") }
                    )
                }

                else -> {
                    Text("Answer type $answerType not supported yet")
                }
            }
        }
    }
}
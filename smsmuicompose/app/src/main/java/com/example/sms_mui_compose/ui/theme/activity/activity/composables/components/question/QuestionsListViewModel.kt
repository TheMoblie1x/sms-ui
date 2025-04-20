package com.example.sms_mui_compose.ui.theme.activity.activity.composables.components.question

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

// Example ViewModel (replace with your actual ViewModel)
class QuestionsListViewModel : ViewModel() {
    var generatedText by mutableStateOf("")
        private set
    var isLoading by mutableStateOf(false)
        private set

    fun generateTextWithAI(inputText: String) {
        viewModelScope.launch {
            isLoading = true
            generatedText = "" // Clear previous result
            // Simulate AI generation (replace with your actual logic)
            delay(2000) // Simulate a 2-second delay
            generatedText = "AI generated text based on: '$inputText'"
            isLoading = false
        }
    }
}
package com.example.sms_mui_compose

import android.app.Application
import android.content.Context
import android.content.Intent
import com.example.sms_mui_compose.ui.theme.activity.activity.ErrorActivity

class Application:Application() {

    fun navigateToErrorScreen(context: Context) {
        context.startActivity(Intent(context, ErrorActivity::class.java))
    }
}
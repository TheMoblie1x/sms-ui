package com.example.sms_mui_compose.ui.theme.activity.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.sms_mui_compose.ui.theme.activity.components.CTextField
import com.example.sms_mui_compose.ui.theme.activity.ui.theme.SmsmuicomposeTheme

class AddCompanyActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SmsmuicomposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()
                , topBar = { TopBar("Add Company",{finish()}) }) { innerPadding ->

                    Row (modifier = Modifier.padding(innerPadding)){
                        CTextField("Company Name")

                    }
                }
            }
        }
    }
}

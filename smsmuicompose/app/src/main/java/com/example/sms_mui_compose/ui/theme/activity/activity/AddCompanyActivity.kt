package com.example.sms_mui_compose.ui.theme.activity.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
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

                    Column (modifier = Modifier.padding(innerPadding)) {
                        CTextField("Company Name")
                        CTextField("Company Id")
                        CTextField("Creation Time")
                        Box {
                            OutlinedButton(onClick = { /*TODO*/ }) {
                                Text(
                                    text = "Click Me",
                                    color = Color.Blue,
                                    fontSize = 18.sp
                                )
                            }

                        }
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun AddCompanyActivityPreview(){
    Scaffold(modifier = Modifier.fillMaxSize()
        , topBar = { TopBar("Add Company",{null}) }) { innerPadding ->
        Column (modifier = Modifier.padding(innerPadding)) {
            CTextField("Company Name")
            CTextField("Company Id")
            CTextField("Creation Time")
            Box {
                OutlinedButton(onClick = { /*TODO*/ }) {
                    Text(
                        text = "Click Me",
                        color = Color.Blue,
                        fontSize = 18.sp
                    )
                }
            }
        }
    }
}
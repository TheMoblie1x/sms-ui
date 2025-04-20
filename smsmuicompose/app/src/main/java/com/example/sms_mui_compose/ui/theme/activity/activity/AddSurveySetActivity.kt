package com.example.sms_mui_compose.ui.theme.activity.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.sms_mui_compose.ui.theme.activity.activity.composables.components.CTextField
import com.example.sms_mui_compose.ui.theme.activity.ui.theme.SmsmuicomposeTheme

class AddSurveySetActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SmsmuicomposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize(), topBar = { TopBar("Add Survey Set",{finish()}) }) { innerPadding ->
                        Column (modifier = Modifier.padding(innerPadding)) {
                            CTextField("Survey Set Name")
//                            CTextField("Survey Set Id") //Survey Set id is auto generated
//                            CTextField("Creation Time") //Creation time of the survey is also auto generated
                            Box {
                                OutlinedButton(onClick = { /*TODO*/ }) {
                                    Text(
                                        text = "Add Survey Set",
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
fun AddSurveySetActivityPreview(){
    SmsmuicomposeTheme {
        Scaffold(modifier = Modifier.fillMaxSize(), topBar = { TopBar("Add Survey Set",{null}) }) { innerPadding ->
            Column (modifier = Modifier.padding(innerPadding)) {
                CTextField("Survey Set Name")
//                CTextField("Survey Set Id") // this needs to be removed since the id is auto assigned by the system
//                CTextField("Creation Time") and also survey creation time is also taken by the system
                Box {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        OutlinedButton(onClick = { /*TODO*/ }) {
                            Text(
                                text = "Add Survey Set",
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
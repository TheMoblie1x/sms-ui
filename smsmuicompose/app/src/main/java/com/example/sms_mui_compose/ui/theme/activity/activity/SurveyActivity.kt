package com.example.sms_mui_compose.ui.theme.activity.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.sms_mui_compose.imageLinks
import com.example.sms_mui_compose.network.company.Company
import com.example.sms_mui_compose.network.survey.Survey
import com.example.sms_mui_compose.ui.theme.SmsmuicomposeTheme
import com.example.sms_mui_compose.ui.theme.activity.activity.CompaniesActivity
import com.example.sms_mui_compose.ui.theme.activity.components.ImageCardData
import com.example.sms_mui_compose.ui.theme.activity.components.ImageGrid


class SurveyActivity :ComponentActivity() {
    var result = mutableListOf<Survey>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        var survey  = getSurveyObject()
        result.add(survey)
        result.add(survey)
        result.add(survey)
        result.add(survey)
        result.add(survey)
        result.add(survey)
        result.add(survey)
        result.add(survey)
        result.add(survey)
        setContent {
            SmsmuicomposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize(), topBar = { TopBar("Survey",{finish()}) }) { innerPadding ->
                    ImageGrid("Add Survey",this@SurveyActivity,
                        getCard(this@SurveyActivity, result!!), innerPadding,Intent(this@SurveyActivity,
                            AddSurveyActivity::class.java))
                }
            }
        }
    }
}

@Composable
fun Greeting5(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Welcome to Companies Activity Where all your compnay data will be shown to you",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview5() {
    SmsmuicomposeTheme {
        Greeting5("Android")
    }
}

fun getSurveyObject():Survey {
    var s = Survey()
    s.surveyId = 1
    s.title = "Rahul's Survey"
    return s
}

fun getCard(context: Context,result:List<Survey>):List<ImageCardData>{
    var list = mutableListOf<ImageCardData>()
    for( i in 0..<result.size){
        val imageCardData = ImageCardData(
            imageUrl = imageLinks[i],
            text = result[i].title,
            onClick = {index-> onClick(context = context,index) }
        )
        list.add(imageCardData)
    }
    return list
}

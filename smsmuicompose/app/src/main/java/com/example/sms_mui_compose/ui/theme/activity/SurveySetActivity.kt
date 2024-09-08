package com.example.sms_mui_compose.ui.theme.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.sms_mui_compose.imageLinks
import com.example.sms_mui_compose.network.GetEntityList
import com.example.sms_mui_compose.network.surveyset.SurveySet
import com.example.sms_mui_compose.ui.theme.SmsmuicomposeTheme
import com.example.sms_mui_compose.ui.theme.activity.components.ImageCardData
import com.example.sms_mui_compose.ui.theme.activity.components.ImageGrid
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

lateinit var resultOfSurveySets:ArrayList<SurveySet>
class SurveySetActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        resultOfSurveySets = intent.extras?.get("SurveySets") as ArrayList<SurveySet>
        setContent {
            SmsmuicomposeTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { TopBar("Survey Sets",{finish()}) }
                ) { innerPadding ->
                    ImageGrid(getSurveyCard(this@SurveySetActivity, resultOfSurveySets), innerPadding)
                }
            }
        }
    }
}


fun getSurveyCard(context: Context, result:ArrayList<SurveySet>):List<ImageCardData>{
    var list = mutableListOf<ImageCardData>()
    for( i in 0..<result.size){
        val imageCardData = ImageCardData(
            imageUrl = imageLinks[i],
            text = result[i].name,
            onClick = {index-> onSurveyItemClick(context = context,index)}
        )
        list.add(imageCardData)
    }
    return list
}



@OptIn(DelicateCoroutinesApi::class)
fun onSurveyItemClick(context:Context, index: Int) {
    val intent  = Intent(context,SurveyActivity::class.java)
    val surveySet = resultOfSurveySets[index]
    lateinit var resultOfSurveySets:List<SurveySet>
    GlobalScope.launch {
        //TODO:FIXME
//        resultOfSurveySets = withContext(Dispatchers.IO){
//            //TODO:FIXME
////            val surveySetId = surveySet.surveySetId.let { Integer.valueOf(it) }
////           GetEntityList().getSurveySetsByGroupID(it)
//        }
        intent.putParcelableArrayListExtra("SurveySets", java.util.ArrayList(resultOfSurveySets))
        context.startActivity(intent)
    }
}


@Composable
fun Greeting6(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Welcome to Companies Activity Where all your compnay data will be shown to you",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview6() {
    SmsmuicomposeTheme {
        Greeting6("Android")
    }
}
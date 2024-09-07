package com.example.sms_mui_compose.ui.theme.activity


import android.content.Context
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
import androidx.lifecycle.lifecycleScope
import com.example.sms_mui_compose.imageLinks
import com.example.sms_mui_compose.network.GetEntityList
import com.example.sms_mui_compose.network.company.Company
import com.example.sms_mui_compose.network.group.Groups
import com.example.sms_mui_compose.ui.theme.SmsmuicomposeTheme
import com.example.sms_mui_compose.ui.theme.activity.components.ImageCardData
import com.example.sms_mui_compose.ui.theme.activity.components.ImageGrid
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
lateinit var resultOfGroups:List<Groups>
class GroupActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val company = intent.extras?.get("Company") as Company

        lifecycleScope.launch {
            resultOfGroups = withContext(Dispatchers.IO){
                val companyID = Integer.valueOf(company.companyId)
                GetEntityList().getAllGroupsByCompany(companyID)
            }
            setContent {
                SmsmuicomposeTheme {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        topBar = { TopBar("Groups",{finish()}) }
                    ) { innerPadding ->
                        ImageGrid(getCard(this@GroupActivity, resultOfGroups), innerPadding)
                    }
                }
            }
        }


//        setContent {
//            SmsmuicomposeTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
////                    Greeting4(
////                        name = "Android",
////                        modifier = Modifier.padding(innerPadding)
////                    )
//                }
//            }
//        }
    }
}

fun getCard(context: Context, result:List<Groups>):List<ImageCardData>{
    var list = mutableListOf<ImageCardData>()
    for( i in 0..<resultOfGroups.size){
        val imageCardData = ImageCardData(
            imageUrl = imageLinks[i],
            text = resultOfGroups[i].name!!,
            onClick = {index-> onClick(context = context,index)}
        )
        list.add(imageCardData)
    }
    return list
}

@Composable
fun Greeting4(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Welcome to Group Activity Where all your Group data will be shown to you",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview4() {
    SmsmuicomposeTheme {
        Greeting4("Android")
    }
}
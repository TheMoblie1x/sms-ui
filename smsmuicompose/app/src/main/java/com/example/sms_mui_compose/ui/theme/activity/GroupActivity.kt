package com.example.sms_mui_compose.ui.theme.activity


import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.example.sms_mui_compose.imageLinks
import com.example.sms_mui_compose.network.GetEntityList
import com.example.sms_mui_compose.network.company.Company
import com.example.sms_mui_compose.network.group.Groups
import com.example.sms_mui_compose.network.surveyset.SurveySet
import com.example.sms_mui_compose.ui.theme.SmsmuicomposeTheme
import com.example.sms_mui_compose.ui.theme.activity.components.ImageCardData
import com.example.sms_mui_compose.ui.theme.activity.components.ImageGrid
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.ArrayList

var resultOfGroups:List<Groups>? = null
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
                        ImageGrid("Add Survey Set",this@GroupActivity,getCard(this@GroupActivity, resultOfGroups!!), innerPadding,
                            Intent(this@GroupActivity,AddGroupActivity::class.java)
                        )
                    }
                }
            }
        }
    }
}

fun getCard(context: Context, result:List<Groups>):List<ImageCardData>{
    var list = mutableListOf<ImageCardData>()
    for( i in 0..<resultOfGroups!!.size){
        val imageCardData = ImageCardData(
            imageUrl = imageLinks[i],
            text = resultOfGroups!![i].name!!,
            onClick = {index-> onGroupItemClick(context = context,index)}
        )
        list.add(imageCardData)
    }
    return list
}


@OptIn(DelicateCoroutinesApi::class)
fun onGroupItemClick(context:Context, index: Int) {
    val intent  = Intent(context,SurveySetActivity::class.java)
    val group = resultOfGroups!![index]
    lateinit var resultOfSurveySets:List<SurveySet>
    GlobalScope.launch {
        resultOfSurveySets = withContext(Dispatchers.IO){
            val groupID = group.groupId?.let { Integer.valueOf(it) }
            groupID?.let { GetEntityList().getSurveySetsByGroupID(it) }!!
        }
        intent.putParcelableArrayListExtra("SurveySets", ArrayList(resultOfSurveySets))
        context.startActivity(intent)
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview4() {
    SmsmuicomposeTheme {
        //Greeting4("Android")
    }
}
package com.example.sms_mui_compose.ui.theme.activity.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.example.sms_mui_compose.imageLinks
import com.example.sms_mui_compose.network.GetEntityList
import com.example.sms_mui_compose.network.company.Company
import com.example.sms_mui_compose.ui.theme.SmsmuicomposeTheme
import com.example.sms_mui_compose.ui.theme.activity.components.ImageCardData
import com.example.sms_mui_compose.ui.theme.activity.components.ImageGrid
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


var result:List<Company>? = null
class CompaniesActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        lifecycleScope.launch {
            result = withContext(Dispatchers.IO){
                GetEntityList().getAllCompaniesList()
            }
            setContent {
                SmsmuicomposeTheme {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        topBar = { TopBar("Companies",{finish()}) }
                        ) { innerPadding ->
                        ImageGrid("Add Group",this@CompaniesActivity,
                            getCard(this@CompaniesActivity, result!!), innerPadding,Intent(this@CompaniesActivity,
                                AddCompanyActivity::class.java))
                    }
                }
            }
        }
    }
}

fun getCard(context: Context,result:List<Company>):List<ImageCardData>{
    var list = mutableListOf<ImageCardData>()
    for( i in 0..<result.size){
        val imageCardData = ImageCardData(
            imageUrl = imageLinks[i],
            text = result[i].name,
            onClick = {index-> onClick(context = context,index) }
        )
        list.add(imageCardData)
    }
    return list
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(text:String,clickEvent:()->Unit){
    return TopAppBar(
        title = { Text(text) },
        navigationIcon = {
            IconButton(onClick = { /* Handle back button click */clickEvent() }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
            }
        }
    )
}

fun onClick(context:Context,index: Int) {
    val intent  = Intent(context, GroupActivity::class.java)
    intent.putExtra("Company", result!![index])
    context.startActivity(intent)
}

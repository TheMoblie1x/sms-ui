package com.example.sms_mui_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.lifecycle.lifecycleScope
import com.example.sms_mui_compose.network.GetEntityList
import com.example.sms_mui_compose.network.company.Companies
import com.example.sms_mui_compose.network.company.Company
import com.example.sms_mui_compose.network.group.GroupsAPI
import com.example.sms_mui_compose.network.survey.SurveysAPI
import com.example.sms_mui_compose.network.surveyset.SurveySetsAPI
import com.example.sms_mui_compose.ui.theme.SmsmuicomposeTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    lateinit var allCompaniesList : List<Company>
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            SmsmuicomposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),topBar = {
                    TopAppBar(title = { Text("My App") })
                }) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Box(modifier = Modifier.padding(16.dp)) {
        Column(modifier = Modifier.padding(32.dp).fillMaxSize()) {
            Text("Welcome to M1x's SMS")
            Text("Survey Management System")
            EmailTextField()
            PasswordTextField()
            LoginButtons()

        }
    }

}

@Composable
fun LoginButtons() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // ... Email and Password TextFields would go here ...

        Button(
            onClick = { /* Handle login logic here */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Login")
        }

        Spacer(modifier = Modifier.height(8.dp)) // Add some spacing

        TextButton(onClick = { /* Handle forgot password logic here */ }) {
            Text("Forgot Password?")
        }
    }
}

@Composable
fun PasswordTextField() {
    var password by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = password,
        onValueChange = { newPassword -> password = newPassword },
        label= { Text("Password") },
        visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        modifier = Modifier.fillMaxWidth(),
        trailingIcon = {
            IconButton(onClick = { showPassword = !showPassword }) {
                Icon(
                    imageVector = if (showPassword) Icons.Filled.ThumbUp else Icons.Filled.Menu,
                    contentDescription = if (showPassword) "Hide password" else "Show password"
                )
            }
        })
}

@Composable
fun EmailTextField() {
    var email by remember { mutableStateOf("") }
    var isValidEmail by remember { mutableStateOf(true) }

    OutlinedTextField(
        value = email,
        onValueChange = { newEmail ->
            email = newEmail
            isValidEmail = android.util.Patterns.EMAIL_ADDRESS.matcher(newEmail).matches()
        },
        label = { Text("Email") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        modifier = Modifier.fillMaxWidth(),
        isError = !isValidEmail
    )

    if (!isValidEmail && email.isNotBlank()) {
        Text(
            text = "Invalid email format",
            color = Color.Red,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(start = 16.dp)
        )}
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SmsmuicomposeTheme {
        Greeting("Android")
    }
}

//
//fun<T> List<T>.print(){
//    for (item in this){
//        println(item.toString())
//    }
//
//}


//TODO:API Calls go here


//val co = GetAPI.getAPIForClass(Companies::class.java)

//
//lifecycleScope.launch {
//    withContext(Dispatchers.IO) { //
//        allCompaniesList = GetEntityList().getAllCompaniesList()
//    }
//    //    allCompaniesList = GetEntityList().getAllCompaniesList()
//    //print(allCompaniesList)
////            for (company in allCompaniesList) {
////                println(company.name)
////            }
//}
//print(allCompaniesList)
//val apiClient = APIClient.get()
//val co = apiClient.create(Companies::class.java)
////        val launch = lifecycleScope.launch { // Use a coroutine scope tied to a lifecycle
////            val allCompanies = co.getAllCompanies()
////            for (company in allCompanies.data) {
////                println(company.name)
////
////            }
////        }
////
////
////        val go = apiClient.create(GroupsAPI::class.java)
////        val launcher = lifecycleScope.launch { // Use a coroutine scope tied to a lifecycle
////            val groups = go.getGroupByCompanyID(41)
////            for (group in groups.data) {
////                println(group.name)
////
////            }
////        }
////
////
////
////        val so = apiClient.create(SurveySetsAPI::class.java)
////        val launcherx = lifecycleScope.launch { // Use a coroutine scope tied to a lifecycle
////            val groups = so.getSurveySetsByGroupId(1461)
////            for (group in groups.data) {
////                println(group.name)
////                println(group.surveySetId)
////
////            }
////        }
//
//
//
////        val xo = apiClient.create(SurveysAPI::class.java)
////        val launcherxx = lifecycleScope.launch { // Use a coroutine scope tied to a lifecycle
////            val groups = xo.getAllSurveys()
////            for (group in groups.data) {
////                //println(group.name)
////                println(group.surveySetId)
////
////            }
////        }
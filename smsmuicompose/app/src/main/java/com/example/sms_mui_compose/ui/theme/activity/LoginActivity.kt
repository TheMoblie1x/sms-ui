package com.example.sms_mui_compose.ui.theme.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import com.example.sms_mui_compose.network.company.Company
import com.example.sms_mui_compose.ui.theme.SmsmuicomposeTheme

class MainActivity : ComponentActivity() {
    lateinit var allCompaniesList : List<Company>
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            SmsmuicomposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),topBar = {
                    TopAppBar(title = { Text("M1x SMS") })
                }) { innerPadding ->
                    Greeting(
                        context = this@MainActivity,
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(context: Context,name: String, modifier: Modifier = Modifier) {
    Box(modifier = Modifier.padding(32.dp)) {
        Column(modifier = Modifier.padding(32.dp).fillMaxSize()) {
            Text("Welcome to M1x's SMS")
            Text("Survey Management System")
            EmailTextField()
            PasswordTextField()
            LoginButtons(context)
        }
    }
}

@Composable
fun LoginButtons(context: Context) {
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
            onClick = { /* Handle login logic here */
                val intent = Intent(context, CompaniesActivity::class.java)
                context.startActivity(intent)
            },
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
        //Greeting(this@MainActivity,"Android")
    }
}

package com.example.login_register_ui.view

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.login_register_ui.R
import com.example.login_register_ui.ui.theme.Purple80

@Composable
fun LoginPage(
    navController: NavController
) {
    val context = LocalContext.current
    val scaffoldState = rememberScrollState()
    val emailVal = remember {
        mutableStateOf("")
    }
    val passwordVal = remember {
        mutableStateOf("")
    }
    val passwordVisibility = remember {
        mutableStateOf(false)
    }
    val defaultColors = OutlinedTextFieldDefaults.colors(
        focusedTextColor = Color.Black,
        unfocusedTextColor = Color.Black,
        focusedContainerColor = Color.White,
        unfocusedContainerColor = Color.White,
        focusedBorderColor = Color.Black,
        unfocusedBorderColor = Color.Black,
        errorBorderColor = Color.Red,
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier.background(Color.White),
                contentAlignment = Alignment.TopCenter
            ) {
                Image(
                    modifier = Modifier
                        .width(400.dp)
                        .height(350.dp),
                    painter = painterResource(id = R.drawable.img),
                    contentDescription = "Login",
                    contentScale = ContentScale.Fit
                )
            }
            Spacer(modifier = Modifier.padding(20.dp))
            Scaffold(
                modifier = Modifier.fillMaxSize(),

            ) { innerPadding ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxWidth()
                        .background(Color.White),
                ) {
                    Text(
                        text = "Sign In",
                        style = TextStyle(
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    )
                    Spacer(modifier = Modifier.padding(20.dp))
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        OutlinedTextField(
                            value = emailVal.value,
                            onValueChange = { emailVal.value = it },
                            label = { Text(text = "Email Address", color = Color.Black) },
                            placeholder = { Text(text = "Email Address", color = Color.Black) },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(0.8f),
                            colors = defaultColors
                        )
                        OutlinedTextField(
                            value = passwordVal.value,
                            onValueChange = { passwordVal.value = it },
                            colors = defaultColors,
                            trailingIcon = {
                                IconButton(
                                    onClick = {
                                        passwordVisibility.value = !passwordVisibility.value
                                    }
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.eye),
                                        contentDescription = "password",
                                        tint = if (passwordVisibility.value) Purple80 else Color.Gray
                                    )
                                }
                            },
                            label = { Text(text = "Password", color = Color.Black) },
                            placeholder = { Text(text = "Password", color = Color.Black) },
                            singleLine = true,
                            visualTransformation = if (passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation(),
                            modifier = Modifier.fillMaxWidth(0.8f),
                        )
                        Spacer(modifier = Modifier.padding(20.dp))
                        Button(
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Gray,

                                ),
                            onClick = {
                                when {
                                    emailVal.value.isEmpty() -> {
                                        Toast.makeText(
                                            context,
                                            "please enter email address",
                                            Toast.LENGTH_LONG
                                        ).show()
                                    }

                                    passwordVal.value.isEmpty() -> {
                                        Toast.makeText(
                                            context,
                                            "please enter password",
                                            Toast.LENGTH_LONG
                                        ).show()
                                    }

                                    else -> {
                                        Toast.makeText(
                                            context,
                                            "login successful",
                                            Toast.LENGTH_LONG
                                        ).show()
                                    }
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth(0.8f)
                                .height(50.dp)
                        ) {
                            Text(
                                text = "Sign In", style = TextStyle(
                                    fontSize = 20.sp,
                                    color = Color.Black
                                )
                            )

                        }
                        Spacer(modifier = Modifier.padding(20.dp))
                        Text(
                            text = "Create an account ?",
                            style = TextStyle(
                                fontSize = 20.sp,
                                color = Color.Black
                            ),
                            modifier = Modifier.clickable {
                                navController.navigate("register_page")
                            }
                        )
                    }

                }
            }
        }
    }
}

@Preview
@Composable
fun LoginPagePreview() {
    LoginPage(navController = rememberNavController())
}
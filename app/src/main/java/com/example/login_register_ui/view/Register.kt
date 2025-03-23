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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.login_register_ui.R
import com.example.login_register_ui.ui.theme.Purple80

@Composable
fun Register(
    navController: NavController
) {
    val context = LocalContext.current
    val nameVal = remember { mutableStateOf("") }
    val emailVal = remember { mutableStateOf("") }
    val phoneVal = remember { mutableStateOf("") }
    val passwordVal = remember { mutableStateOf("") }
    val confirmPasswordVal = remember { mutableStateOf("") }

    val passwordVisibility = remember { mutableStateOf(false) }
    val confirmPasswordVisibility = remember { mutableStateOf(false) }
    val defaultColors = OutlinedTextFieldDefaults.colors(
        focusedTextColor = Black,
        unfocusedTextColor = Black,
        focusedContainerColor = White,
        unfocusedContainerColor = White,
        focusedBorderColor = Black,
        unfocusedBorderColor = Black,
        errorBorderColor = Color.Red,
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = White),
        contentAlignment = Alignment.BottomCenter
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(White),
                contentAlignment = Alignment.TopCenter
            ) {
                Image(
                    painter = painterResource(R.drawable.register_img),
                    contentDescription = "Register Image",
                    modifier = Modifier
                        .width(300.dp)
                        .height(300.dp),
                    contentScale = ContentScale.Fit
                )
            }
            Scaffold(
                modifier = Modifier.fillMaxSize().background(White),
            ) { paddingValues ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(30.dp))
                        .background(White)
                        .padding(paddingValues),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Sign Up",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        OutlinedTextField(
                            value = nameVal.value,
                            onValueChange = { nameVal.value = it },
                            label = { Text(text = "Name", color = Black) },
                            placeholder = { Text(text = "Name", color = Black) },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(0.8f),
                            colors = defaultColors
                        )

                        OutlinedTextField(
                            value = emailVal.value,
                            onValueChange = { emailVal.value = it },
                            label = { Text(text = "Email Address", color = Black) },
                            placeholder = { Text(text = "Email Address", color = Black) },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(0.8f),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                            colors = defaultColors
                        )

                        OutlinedTextField(
                            value = phoneVal.value,
                            onValueChange = { phoneVal.value = it },
                            label = { Text(text = "Phone Number", color = Black) },
                            placeholder = { Text(text = "Phone Number", color = Black) },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(0.8f),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                            colors = defaultColors
                        )

                        OutlinedTextField(
                            value = passwordVal.value,
                            onValueChange = { passwordVal.value = it },
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
                            label = { Text(text = "Password", color = Black) },
                            placeholder = { Text(text = "Password", color = Black) },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(0.8f),
                            colors = defaultColors,
                            visualTransformation = if (passwordVisibility.value) VisualTransformation.None
                            else PasswordVisualTransformation()
                        )

                        OutlinedTextField(
                            value = confirmPasswordVal.value,
                            onValueChange = { confirmPasswordVal.value = it },
                            label = { Text(text = "Password", color = Black) },
                            placeholder = { Text(text = "Password", color = Black) },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(0.8f),
                            colors = defaultColors,
                            trailingIcon = {
                                IconButton(
                                    onClick = {
                                        confirmPasswordVisibility.value =
                                            !confirmPasswordVisibility.value
                                    }
                                ) {
                                    Icon(
                                        painter = painterResource(R.drawable.eye),
                                        contentDescription = "Password Eye",
                                        tint = if (confirmPasswordVisibility.value) Purple80 else Color.Gray
                                    )
                                }
                            },
                            visualTransformation = if (confirmPasswordVisibility.value) VisualTransformation.None
                            else PasswordVisualTransformation()
                        )

                        Spacer(modifier = Modifier.padding(10.dp))
                        Button(colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Gray,
                        ),
                            onClick = {
                                if (nameVal.value.isEmpty()) {
                                    Toast.makeText(
                                        context,
                                        "Please enter the name!",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                } else if (emailVal.value.isEmpty()) {
                                    Toast.makeText(
                                        context,
                                        "Please enter the email address!",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                } else if (phoneVal.value.isEmpty()) {
                                    Toast.makeText(
                                        context,
                                        "Please enter the phone number!",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                } else if (passwordVal.value.isEmpty()) {
                                    Toast.makeText(
                                        context,
                                        "Please enter password!",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                } else if (confirmPasswordVal.value.isEmpty()) {
                                    Toast.makeText(
                                        context,
                                        "Please enter confirm password!",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                } else {
                                    Toast.makeText(
                                        context,
                                        "Successfully Registered!",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                        ) {
                            Text(text = "Sign Up", fontSize = 20.sp, color = Black)
                        }
                        Spacer(modifier = Modifier.padding(5.dp))

                        Text(text = "Login Instead", color = Black,
                            modifier = Modifier.clickable {
                                navController.navigate("login_page")
                            }
                        )
                    }

                }
            }
        }
    }
}
package com.alihan.messageapp.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alihan.messageapp.R
import com.alihan.messageapp.ui.theme.Black
import com.alihan.messageapp.ui.theme.BlueGray

@Composable
fun LoginScreen() {
    Surface {
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val uiColors = if (isSystemInDarkTheme()) Color.White else Color.Black

            Box(contentAlignment = Alignment.TopCenter) {
                Image(
                    modifier = Modifier.fillMaxWidth(),
                    painter = painterResource(id = R.drawable.shape),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds
                )

                Row(
                    modifier = Modifier.padding(top = 120.dp),
                    verticalAlignment = Alignment.Top
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.chat),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.padding(end = 10.dp))
                    Column {
                        Text(
                            text = stringResource(id = R.string.app_name),
                            style = MaterialTheme.typography.headlineMedium,
                            color = uiColors
                        )
                        Text(
                            text = stringResource(id = R.string.welcome),
                            style = MaterialTheme.typography.titleMedium,
                            color = uiColors
                        )
                    }
                }
            }

            Text(
                modifier = Modifier
                    .padding(bottom = 20.dp)
                    .align(Alignment.CenterHorizontally),
                text = stringResource(id = R.string.login),
                style = MaterialTheme.typography.headlineMedium,
                color = uiColors
            )

            OutlinedTextField(
                value = email,
                maxLines = 1,
                onValueChange = { email = it },
                modifier = Modifier
                    .padding(start = 25.dp, end = 25.dp, bottom = 10.dp)
                    .fillMaxWidth(),
                label = { Text(text = stringResource(id = R.string.email)) }
            )
            
            OutlinedTextField(
                value = password,
                maxLines = 1,
                onValueChange = { password = it },
                modifier = Modifier
                    .padding(start = 25.dp, end = 25.dp, bottom = 10.dp)
                    .fillMaxWidth(),
                label = { Text(text = stringResource(id = R.string.password)) }
            )

            Button(onClick = {  }, modifier = Modifier
                .padding(start = 25.dp, end = 25.dp, top = 10.dp)
                .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if(isSystemInDarkTheme()) BlueGray else Black,
                    contentColor = White),
                shape = RoundedCornerShape(size = 10.dp),
                enabled = if(email.isNotEmpty() && password.isNotEmpty()) true else false) {
                Text(text = stringResource(id = R.string.signin))
            }
            Row (modifier = Modifier.padding(top = 10.dp), horizontalArrangement = Arrangement.Center){
                Text(
                    text = stringResource(id = R.string.dont_have_account),
                    color = Color.Gray,
                    style = TextStyle(fontSize = 13.sp)
                    )
                Text(
                    modifier = Modifier.padding(start = 4.dp),
                    text = stringResource(id = R.string.signup),
                    color = if(isSystemInDarkTheme()) White else Black,
                    style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 13.sp)
                )
                
            }
            
            
        }
    }
}

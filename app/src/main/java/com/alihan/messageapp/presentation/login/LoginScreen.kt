package com.alihan.messageapp.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.alihan.messageapp.R

@Composable
fun LoginScreen() {
    Surface {
        Column(modifier = Modifier.fillMaxSize()) {
            val uiColors=if (isSystemInDarkTheme()) Color.White else Color.Black

            Box(
                contentAlignment = Alignment.TopCenter){
                Image(
                    painter = painterResource(
                    id = R.drawable.shape),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds)
            }

        }
    }
}
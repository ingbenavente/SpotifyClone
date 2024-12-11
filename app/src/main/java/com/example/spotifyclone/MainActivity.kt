// MainActivity.kt
package com.example.spotifyclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpotifyLoginScreen()
        }
    }
}

@Composable
fun SpotifyLoginScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(100.dp))

        // Spotify Logo
        Image(
            painter = painterResource(id = R.drawable.logospotify),
            contentDescription = "Spotify Logo",
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(150.dp)
        )

        Spacer(modifier = Modifier.height(50.dp))

        // Login Button
        Button(
            onClick = { /* Handle Login */ },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF1DB954)),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(25.dp)
        ) {
            Text(text = "Log In", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Sign Up Button
        OutlinedButton(
            onClick = { /* Handle Sign Up */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(25.dp),
            border = androidx.compose.foundation.BorderStroke(1.dp, Color.White)
        ) {
            Text(text = "Regístrate Gratis", color = Color.Black, fontSize = 16.sp, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(40.dp))

        // Continue Options
        Text(text = "Continue with", color = Color.White, fontSize = 14.sp)

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            SocialLoginButtonWithIcon(platform = "Google", icon = R.drawable.logogoogle)
            SocialLoginButtonWithIcon(platform = "Facebook", icon = R.drawable.logoface)
            SocialLoginButtonWithIcon(platform = "Apple", icon = R.drawable.logoapple)
        }
    }
}

@Composable
fun SocialLoginButtonWithIcon(platform: String, icon: Int) {
    OutlinedButton(
        onClick = { /* Handle Social Login */ },
        modifier = Modifier
            .width(100.dp)
            .height(50.dp),
        shape = RoundedCornerShape(25.dp),
        border = androidx.compose.foundation.BorderStroke(1.dp, Color.White)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = "$platform Icon",
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

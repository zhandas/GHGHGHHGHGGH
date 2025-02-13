package com.example.mycolor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mycolor.ui.theme.DarkTheme
import com.example.mycolor.ui.theme.LightTheme
import com.example.mycolor.ui.theme.MyColorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var darkTheme by remember { mutableStateOf(false) }
            MyColorTheme(
                darkTheme = darkTheme
            ) {
                AppContent(darkTheme){
                    darkTheme = it
                }
            }

        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppContent(isDarkTheme: Boolean, onThemeChange: (Boolean) -> Unit) {
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Theme Switcher") },
                actions = {
                    Switch(
                        checked = isDarkTheme,
                        onCheckedChange = { onThemeChange(it) }
                    )
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Text("Current Theme: ${if (isDarkTheme) "Dark" else "Light"}")
        }
    }
}
package com.intelliatech.policytestdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.intelliatech.policytestdemo.ui.theme.PolicyTestDemoTheme
import com.intelliatech.policytestdemo.ui.theme.screen.PolicyScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PolicyTestDemoTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    PolicyScreen()
                }
            }
        }
    }
}

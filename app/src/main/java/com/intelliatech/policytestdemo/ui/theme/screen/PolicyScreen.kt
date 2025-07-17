package com.intelliatech.policytestdemo.ui.theme.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.intelliatech.policytestdemo.R
import com.intelliatech.policytestdemo.ui.theme.components.PolicyCard
import com.intelliatech.policytestdemo.ui.theme.navigation.BottomNavigationBar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PolicyScreen(viewModel: PolicyViewModel = hiltViewModel()) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_launcher_foreground), // your logo
                            contentDescription = "App Logo",
                            modifier = Modifier
                                .size(32.dp)
                                .padding(end = 8.dp)
                        )
                        Text("My Policies")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF002C5F),
                    titleContentColor = Color.White
                )
            )
        },
        bottomBar = {
            BottomNavigationBar()
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            items(viewModel.policies.value) { policy ->
                PolicyCard(policy = policy) {
                    viewModel.toggleExpand(policy.id)
                }
            }
        }
    }
}


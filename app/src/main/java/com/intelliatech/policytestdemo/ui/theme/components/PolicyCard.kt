package com.intelliatech.policytestdemo.ui.theme.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.intelliatech.policytestdemo.data.model.Policy

@Composable
fun PolicyCard(policy: Policy, onToggleExpand: () -> Unit) {
    val statusColor = if (policy.status == "Active") MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.tertiary

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column {
                    Text(
                        text = policy.name,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Policy #: ${policy.number}",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Gray
                    )
                }

                Box(
                    modifier = Modifier
                        .background(statusColor, RoundedCornerShape(12.dp))
                        .padding(horizontal = 12.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = policy.status,
                        style = MaterialTheme.typography.labelMedium,
                        color = Color.White,
                        fontWeight = FontWeight.Medium
                    )
                }
            }

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = "Next Premium Due: ${policy.nextPremiumDue}",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = if (policy.isExpanded) "Read Less ▲" else "Read More ▼",
                modifier = Modifier
                    .clickable { onToggleExpand() }
                    .padding(vertical = 4.dp),
                color = MaterialTheme.colorScheme.primary,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal
            )

            AnimatedVisibility(visible = policy.isExpanded) {
                Column(modifier = Modifier.padding(top = 8.dp)) {
                    PolicyDetailItem("Start Date", policy.startDate)
                    PolicyDetailItem("Maturity Date", policy.maturityDate)
                    PolicyDetailItem("Sum Assured", policy.sumAssured)
                    PolicyDetailItem("Premium Frequency", policy.premiumFrequency)
                    PolicyDetailItem("Last Premium Paid", policy.lastPremiumPaid)
                    PolicyDetailItem("Next Premium Amount", policy.nextPremiumAmount)
                }
            }
        }
    }
}

@Composable
fun PolicyDetailItem(label: String, value: String) {
    Row(modifier = Modifier.padding(vertical = 2.dp)) {
        Text(
            text = "$label: ",
            fontWeight = FontWeight.Medium,
            style = MaterialTheme.typography.bodySmall
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodySmall,
            color = Color.DarkGray
        )
    }
}


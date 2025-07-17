package com.intelliatech.policytestdemo.data.model

data class Policy(
    val id: String,
    val name: String,
    val number: String,
    val status: String,
    val nextPremiumDue: String,
    val startDate: String,
    val maturityDate: String,
    val sumAssured: String,
    val premiumFrequency: String,
    val lastPremiumPaid: String,
    val nextPremiumAmount: String,
    var isExpanded: Boolean = false // for animation state
)

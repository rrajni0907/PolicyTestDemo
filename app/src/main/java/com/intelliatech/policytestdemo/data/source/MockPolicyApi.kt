package com.intelliatech.policytestdemo.data.source

import com.intelliatech.policytestdemo.data.model.Policy

object MockPolicyApi {
    fun fetchPolicies(): List<Policy> {
        return listOf(
            Policy("1", "Life Secure", "LS12345", "Active", "2025-08-01", "2020-08-01", "2040-08-01", "₹5,00,000", "Yearly", "2024-08-01", "₹25,000"),
            Policy("2", "Health Plus", "HP98765", "Lapsed", "2025-01-01", "2021-01-01", "2031-01-01", "₹3,00,000", "Monthly", "2024-12-01", "₹1,500"),
            Policy("3", "Wealth Build", "WB24680", "Active", "2025-09-15", "2019-09-15", "2039-09-15", "₹10,00,000", "Half-Yearly", "2024-09-15", "₹12,500")
        )
    }
}

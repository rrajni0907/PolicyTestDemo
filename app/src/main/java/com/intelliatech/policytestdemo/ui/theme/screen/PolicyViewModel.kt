package com.intelliatech.policytestdemo.ui.theme.screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.intelliatech.policytestdemo.data.model.Policy
import com.intelliatech.policytestdemo.data.source.MockPolicyApi
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class PolicyViewModel @Inject constructor() : ViewModel() {

    private val _policies = mutableStateOf<List<Policy>>(emptyList())
    val policies: State<List<Policy>> = _policies

    init {
        loadPolicies()
    }

    private fun loadPolicies() {
        _policies.value = MockPolicyApi.fetchPolicies()
    }

    fun toggleExpand(policyId: String) {
        _policies.value = _policies.value.map {
            if (it.id == policyId) it.copy(isExpanded = !it.isExpanded) else it
        }
    }
}

package com.example.moneyflow.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moneyflow.model.Expense
import com.example.moneyflow.model.ExpenseRepository
import kotlinx.coroutines.launch

class ExpenseViewModel(private val repository: ExpenseRepository) : ViewModel() {
    val expenses: LiveData<List<Expense>> = repository.expenses

    fun addExpense(expense: Expense) {
        viewModelScope.launch {
            repository.insert(expense)
        }
    }

    fun getExpensesByDateRange(startDate: String, endDate: String): LiveData<List<Expense>> {
        return repository.getExpensesByDateRange(startDate, endDate)
    }
}

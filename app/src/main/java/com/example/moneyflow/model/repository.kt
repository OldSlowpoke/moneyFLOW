package com.example.moneyflow.model

import androidx.lifecycle.LiveData

class ExpenseRepository(private val expenseDao: ExpenseDao) {
    val expenses: LiveData<List<Expense>> = expenseDao.getAllExpenses()

    fun getExpensesByDateRange(startDate: String, endDate: String): LiveData<List<Expense>> {
        return expenseDao.getExpensesByDateRange(startDate, endDate)
    }

    suspend fun insert(expense: Expense) {
        expenseDao.insert(expense)
    }
}

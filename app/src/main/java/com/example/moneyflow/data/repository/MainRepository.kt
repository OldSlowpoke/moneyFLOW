package com.example.moneyflow.data.repository

import androidx.lifecycle.LiveData
import com.example.moneyflow.data.database.dao.AccountsDao
import com.example.moneyflow.data.database.dao.ExpensesDao
import com.example.moneyflow.data.database.dao.IncomesDao
import com.example.moneyflow.data.database.model.Expenses
import com.example.moneyflow.data.database.model.Incomes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class MainRepository(
    private val expensesDao: ExpensesDao,
    private val incomesDao: IncomesDao,
    private val accountsDao: AccountsDao
) {
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    val expenses: LiveData<List<Expenses>> = expensesDao.getLastThirtyExpenses()
    val incomes: LiveData<List<Incomes>> = incomesDao.getLastThirtyIncomes()
    val balance: LiveData<Double> = accountsDao.getBalance()

    fun deleteExpense(expense: Expenses) {
        TODO("Not yet implemented")
    }
    fun deleteIncome(income: Incomes) {
        TODO("Not yet implemented")
    }
}


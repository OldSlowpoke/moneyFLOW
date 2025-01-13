package com.example.moneyflow.data.repository

import androidx.lifecycle.LiveData
import com.example.moneyflow.data.database.connections.ExpenseWithProduct
import com.example.moneyflow.data.database.connections.IncomensWithType
import com.example.moneyflow.data.database.dao.AccountsDao
import com.example.moneyflow.data.database.dao.ExpensesDao
import com.example.moneyflow.data.database.dao.IncomesDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class MainRepository(
    private val expensesDao: ExpensesDao,
    private val incomesDao: IncomesDao,
    private val accountsDao: AccountsDao
) {
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    val expenses: LiveData<List<ExpenseWithProduct>> = expensesDao.getLastThirtyExpenses()
    val incomes: LiveData<List<IncomensWithType>> = incomesDao.getLastThirtyIncomes()
    val balance: LiveData<Double> = accountsDao.getBalance()

    fun deleteExpense(expense: ExpenseWithProduct) {
        TODO("Not yet implemented")
    }
    fun deleteIncome(income: IncomensWithType) {
        TODO("Not yet implemented")
    }
}


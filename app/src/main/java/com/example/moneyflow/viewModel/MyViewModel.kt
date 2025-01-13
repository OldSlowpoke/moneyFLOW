package com.example.moneyflow.viewModel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.moneyflow.data.database.UserRoomDatabase
import com.example.moneyflow.data.database.connections.ExpenseWithProduct
import com.example.moneyflow.data.database.connections.IncomensWithType
import com.example.moneyflow.data.database.dao.AccountsDao
import com.example.moneyflow.data.repository.MainRepository

class MyViewModel (application: Application) : ViewModel(){

    private val repository: MainRepository
    val expenses: LiveData<List<ExpenseWithProduct>>
    val incomes: LiveData<List<IncomensWithType>>
    val balance: LiveData<Double>

    init {
        val userDb = UserRoomDatabase.getInstance(application)
        val expensesDao = userDb.expensesDao()
        val incomesDao = userDb.incomesDao()
        val accountsDao = userDb.accountsDao()
        repository = MainRepository(expensesDao, incomesDao, accountsDao)
        expenses = repository.expenses
        incomes = repository.incomes
        balance = repository.balance
    }
    fun deleteExpense(expense: ExpenseWithProduct){
        repository.deleteExpense(expense)
    }
    fun deleteIncome(income: IncomensWithType){
        repository.deleteIncome(income)
    }
}
package com.example.moneyflow.design

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.material3.Button
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.livedata.observeAsState
import com.example.moneyflow.model.Expense
import com.example.moneyflow.viewmodel.ExpenseViewModel

@Composable
fun Home(viewModel: ExpenseViewModel) {
    val expenses = viewModel.expenses.observeAsState(emptyList()).value

    Column {
        Button(onClick = {
            val newExpense = Expense(accountId = 1, typeId = 1, date = "2023-10-01")
            viewModel.addExpense(newExpense)
        }) {
            Text(text = "Add Expense")
        }

        LazyColumn {
            items(expenses) { expense ->
                Text(text = expense.date)
            }
        }
    }
}


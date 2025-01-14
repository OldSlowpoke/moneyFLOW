package com.example.moneyflow.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.moneyflow.data.database.connections.ExpenseWithProduct
import com.example.moneyflow.data.database.model.Expenses
import com.example.moneyflow.data.database.model.Incomes
import com.example.moneyflow.viewModel.MyViewModel


@Composable
fun Home(navController: NavController, vm: MyViewModel = viewModel()) {
    val expenses by vm.expenses.observeAsState(listOf())
    val incomes by vm.incomes.observeAsState(listOf())
    val balance by vm.balance.observeAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        TopSection(balance = balance)
        TransactionList(expenses = expenses, incomes = incomes, delExpense = { vm.deleteExpense(it) }, delIncome = { vm.deleteIncome(it) })
    }
}

@Composable
fun TopSection(balance: Double?) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
            ) {
                Text(text = "Баланс Руб")
                Text(text = balance?.toString() ?: "0.0")
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            ActionButton(icon = Icons.Filled.Add, text = "Д") { /* Handle click */ }
            ActionButton(icon = Icons.Filled.AccountCircle, text = "QR") { /* Handle click */ }
            ActionButton(icon = Icons.Filled.Edit, text = "Р") { /* Handle click */ }
            ActionButton(icon = Icons.Filled.Settings, text = "Обj") { /* Handle click */ }
        }
    }
}

@Composable
fun ActionButton(icon: ImageVector, text: String, onClick: () -> Unit) {
    Button(onClick = onClick) {
        Icon(imageVector = icon, contentDescription = null)
        Text(text = text)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TransactionList(
    expenses: List<Expenses>,
    incomes: List<Incomes>,
    delExpense: (Expenses) -> Unit,
    delIncome: (Incomes) -> Unit
) {
    var activeButton by remember { mutableStateOf(1) }

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Button(
            onClick = { activeButton = 1 },
            modifier = Modifier.background(if (activeButton == 1) Color.Green else Color.Gray)
        ) {
            Text("Button 1")
        }
        Button(
            onClick = { activeButton = 2 },
            modifier = Modifier.background(if (activeButton == 2) Color.Green else Color.Gray)
        ) {
            Text("Button 2")
        }
        if (activeButton == 1){
            val groups = expenses.groupBy { it.date }
            LazyColumn {
                groups.forEach { (date, costs) ->
                    stickyHeader {
                        Text(
                            text = date.toString()
                        )
                    }
                    items(costs.size) { index ->
                        TransactionItem(transaction = costs[index], onDelete = delExpense)
                    }
                }
            }
        }else{
            val groups = incomes.groupBy { it.date }
            LazyColumn {
                groups.forEach { (date, incomes) ->
                    stickyHeader {
                        Text(
                            text = date.toString()
                        )
                    }
                    items(incomes.size) { index ->
                        TransactionItem(transaction = incomes[index], onDelete = delIncome)
                    }
                }
            }
        }
    }
}

@Composable
fun TransactionItem(transaction: Expenses, onDelete: (Expenses) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = !expanded }
                .padding(16.dp)
        ) {
            Text(text = transaction.expensesType)
            Spacer(modifier = Modifier.weight(1f))
            Text(text = transaction.total.toString())
        }
        if (expanded) {
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(
                    onClick = { /* Handle edit */ },
                    text = {Text("Редактировать")}
                )
                DropdownMenuItem(
                    onClick = { onDelete(transaction) },
                    text = {Text("Удалить")}
                )
            }
        }
    }
}

@Composable
fun TransactionItem(transaction: Incomes, onDelete: (Incomes) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = !expanded }
                .padding(16.dp)
        ) {
            Text(text = transaction.incomeType)
            Spacer(modifier = Modifier.weight(1f))
            Text(text = transaction.incomesAmount.toString())
        }
        if (expanded) {
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(
                    onClick = { /* Handle edit */ },
                    text = {Text("Редактировать")}
                )
                DropdownMenuItem(
                    onClick = { onDelete(transaction) },
                    text = {Text("Удалить")}
                )
            }
        }
    }
}




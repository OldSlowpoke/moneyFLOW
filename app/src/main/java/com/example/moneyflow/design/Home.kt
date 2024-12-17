package com.example.moneyflow.design

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Camera
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable
fun Home(navController: NavController, viewModel: TransactionViewModel = viewModel()) {
    val transactions by viewModel.transactions.collectAsState()
    val balance by viewModel.balance.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        TopSection(balance = balance)
        TransactionList(transactions = transactions, onDelete = { viewModel.deleteTransaction(it) })
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
            ActionButton(icon = Icons.Filled.Camera, text = "QR") { /* Handle click */ }
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

@Composable
fun TransactionList(transactions: List<Transaction>, onDelete: (Transaction) -> Unit) {
    LazyColumn {
        items(transactions.groupBy { it.date }) {
            StickyHeader {
                Text(text = it.key, style = MaterialTheme.typography.headlineSmall)
            }
            items(it.value) { transaction ->
                TransactionItem(transaction = transaction, onDelete = onDelete)
            }
        }
    }
}

@Composable
fun TransactionItem(transaction: Transaction, onDelete: (Transaction) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = !expanded }
                .padding(16.dp)
        ) {
            Text(text = transaction.description)
            Spacer(modifier = Modifier.weight(1f))
            Text(text = transaction.amount.toString())
        }
        if (expanded) {
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(onClick = { /* Handle edit */ }) {
                    Text(text = "Редактировать")
                }
                DropdownMenuItem(onClick = { onDelete(transaction) }) {
                    Text(text = "Удалить")
                }
            }
        }
    }
}



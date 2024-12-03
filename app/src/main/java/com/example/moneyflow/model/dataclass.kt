package com.example.moneyflow.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true) val userId: Int,
    val name: String,
    val birthDate: String,
    val login: String,
    val password: String
)

@Entity(tableName = "asset_types")
data class AssetType(
    @PrimaryKey(autoGenerate = true) val typeId: Int,
    val name: String,
    val description: String
)

@Entity(tableName = "assets")
data class Asset(
    @PrimaryKey(autoGenerate = true) val assetId: Int,
    val typeId: Int,
    val accountId: Int
)

@Entity(tableName = "accounts")
data class Account(
    @PrimaryKey(autoGenerate = true) val accountId: Int,
    val name: String
)

@Entity(tableName = "analytic_reports")
data class AnalyticReport(
    @PrimaryKey(autoGenerate = true) val reportId: Int,
    val userId: Int,
    val accountId: Int,
    val date: String,
    val totalExpenses: Double,
    val totalIncome: Double,
    val expenseCount: Int,
    val incomeCount: Int
)

@Entity(tableName = "expense_types")
data class ExpenseType(
    @PrimaryKey(autoGenerate = true) val typeId: Int,
    val name: String,
    val description: String
)

@Entity(tableName = "expenses")
data class Expense(
    @PrimaryKey(autoGenerate = true) val expenseId: Int,
    val accountId: Int,
    val typeId: Int,
    val date: String
){
    // Вторичный конструктор
    constructor(accountId: Int, typeId: Int, date: String) : this(0, accountId, typeId, date)
}

@Entity(tableName = "income_types")
data class IncomeType(
    @PrimaryKey(autoGenerate = true) val typeId: Int,
    val name: String,
    val description: String
)

@Entity(tableName = "incomes")
data class Income(
    @PrimaryKey(autoGenerate = true) val incomeId: Int,
    val accountId: Int,
    val typeId: Int,
    val date: String,
    val amount: Double
)

@Entity(tableName = "receipts")
data class Receipt(
    @PrimaryKey(autoGenerate = true) val receiptId: Int,
    val expenseId: Int,
    val unitId: Int,
    val pricePerUnit: Double
)

@Entity(tableName = "items")
data class Item(
    @PrimaryKey(autoGenerate = true) val itemId: Int,
    val receiptId: Int,
    val productId: Int,
    val quantity: Int
)

@Entity(tableName = "products")
data class Product(
    @PrimaryKey(autoGenerate = true) val productId: Int,
    val description: String,
    val categoryId: Int
)

@Entity(tableName = "units_of_measure")
data class UnitOfMeasure(
    @PrimaryKey(autoGenerate = true) val unitId: Int,
    val name: String
)

@Entity(tableName = "categories")
data class Category(
    @PrimaryKey(autoGenerate = true) val categoryId: Int,
    val name: String
)

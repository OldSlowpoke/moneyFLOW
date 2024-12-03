package com.example.moneyflow.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        User::class, AssetType::class, Asset::class, Account::class, AnalyticReport::class,
        ExpenseType::class, Expense::class, IncomeType::class, Income::class, Receipt::class,
        Item::class, Product::class, UnitOfMeasure::class, Category::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun assetTypeDao(): AssetTypeDao
    abstract fun assetDao(): AssetDao
    abstract fun accountDao(): AccountDao
    abstract fun analyticReportDao(): AnalyticReportDao
    abstract fun expenseTypeDao(): ExpenseTypeDao
    abstract fun expenseDao(): ExpenseDao
    abstract fun incomeTypeDao(): IncomeTypeDao
    abstract fun incomeDao(): IncomeDao
    abstract fun receiptDao(): ReceiptDao
    abstract fun itemDao(): ItemDao
    abstract fun productDao(): ProductDao
    abstract fun unitOfMeasureDao(): UnitOfMeasureDao
    abstract fun categoryDao(): CategoryDao
}

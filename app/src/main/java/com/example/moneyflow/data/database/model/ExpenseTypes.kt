package com.example.moneyflow.data.database.model

import androidx.compose.runtime.Immutable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "expense_types")
@Immutable
data class ExpenseTypes(
    @PrimaryKey(autoGenerate = true) val expenseTypeId: Int,
    val expenseTypeNumber: String,
    val expenseTypeDescription: String
)
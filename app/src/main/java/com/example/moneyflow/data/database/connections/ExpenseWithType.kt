package com.example.moneyflow.data.database.connections

import androidx.room.Embedded
import androidx.room.Relation
import com.example.moneyflow.data.database.model.ExpenseTypes
import com.example.moneyflow.data.database.model.Expenses

data class ExpenseWithType (
    @Embedded
    val expenseTypes: Expenses,
    @Relation(
        parentColumn = "expenseTypeId",
        entityColumn = "expenseTypeId"
    )
    val expenses: ExpenseTypes
)
package com.example.moneyflow.data.database.connections

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.moneyflow.data.database.model.Expenses
import com.example.moneyflow.data.database.model.Product
import com.example.moneyflow.data.database.model.ReceiptItem

data class ExpenseWithProduct (
    @Embedded
    val expense: Expenses,
    @Relation(
        parentColumn = "expenseId",
        entityColumn = "productId",
        associateBy = Junction(ReceiptItem::class)
    )
    val product: List<Product>
)
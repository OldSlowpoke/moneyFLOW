package com.example.moneyflow.data.database.model

import androidx.compose.runtime.Immutable
import androidx.room.Entity
import androidx.room.Index

@Entity(tableName = "receiptItem",
    primaryKeys = ["expenseId", "productId"],
    indices = [Index(value = ["productId"]), Index(value = ["expenseId"])]
)
@Immutable
data class ReceiptItem(
    val expenseId: Int,
    val productId: Int,
    val unit: String,
    val pricePerUnit: Double,
    val quantity: Int,
    val discount: Boolean,
)
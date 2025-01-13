package com.example.moneyflow.data.database.model

import androidx.compose.runtime.Immutable
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

@Entity(tableName = "receiptItem",
    primaryKeys = ["expenseId", "productId"],
    foreignKeys = [
        ForeignKey(
            entity = UnitsOfMeasurement::class,
            parentColumns = ["unitId"],
            childColumns = ["unitId"],
            onDelete = androidx.room.ForeignKey.CASCADE
        ),
    ],
    indices = [Index(value = ["productId","unitId","expenseId"])]
)
@Immutable
data class ReceiptItem(
    val expenseId: Int,
    val productId: Int,
    val unitId: Int,
    val pricePerUnit: Double,
    val quantity: Int,
    val discount: Boolean,
    val total: Double
)
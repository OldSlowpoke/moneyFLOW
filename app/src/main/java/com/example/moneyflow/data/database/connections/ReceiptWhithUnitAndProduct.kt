package com.example.moneyflow.data.database.connections

import androidx.room.Embedded
import androidx.room.Relation
import com.example.moneyflow.data.database.model.Product

data class ReceiptWhithUnitAndProduct (
    @Embedded
    val product: Product,
    @Relation(
        parentColumn = "categoryId",
        entityColumn = "categoryId"
    )
    val receiptWithUnit: List<ReceiptWithUnit>
)
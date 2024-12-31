package com.example.moneyflow.data.database.connections

import androidx.room.Embedded
import androidx.room.Relation
import com.example.moneyflow.data.database.model.ReceiptItem
import com.example.moneyflow.data.database.model.UnitsOfMeasurement


data class ReceiptWithUnit (
    @Embedded
    val unitsOfMeasurement : UnitsOfMeasurement,
    @Relation(
        parentColumn = "unitId",
        entityColumn = "unitId"
    )
    val receiptItem : ReceiptItem
)
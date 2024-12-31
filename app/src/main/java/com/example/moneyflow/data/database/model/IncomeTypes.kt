package com.example.moneyflow.data.database.model

import androidx.compose.runtime.Immutable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "income_types")
@Immutable
data class IncomeTypes(
    @PrimaryKey(autoGenerate = true) val incomeTypeId: Int,
    val incomeTypeNumber: String,
    val incomeTypeDescription: String
)
package com.example.moneyflow.data.database.model

import androidx.compose.runtime.Immutable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "units_of_measurement")
@Immutable
data class UnitsOfMeasurement(
    @PrimaryKey(autoGenerate = true) val unitId: Int,
    val unitName: String,
)
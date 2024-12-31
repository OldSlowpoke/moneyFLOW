package com.example.moneyflow.data.database.model

import androidx.compose.runtime.Immutable
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.time.OffsetDateTime

@Entity(tableName = "analytical_reports",
    foreignKeys = [
        ForeignKey(
            entity = Users::class,
            parentColumns = ["userid"],
            childColumns = ["userid"],
            onDelete = androidx.room.ForeignKey.CASCADE
        ),
    ],
    indices = [Index(value = ["userid"])]
)
@Immutable
data class AnalyticalReports(
    @PrimaryKey(autoGenerate = true) val analyticalReportId: Int,
    val userid: Int,
    val date: OffsetDateTime = OffsetDateTime.now(), // Значение по умолчанию,
    val spendingAmount: Double,
    val incomeAmount: Double,
    val numberOfAmount: Int,
    val numberOfIncomes: Int
)
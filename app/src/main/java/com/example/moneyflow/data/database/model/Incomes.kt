package com.example.moneyflow.data.database.model

import androidx.compose.runtime.Immutable
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.time.OffsetDateTime

@Entity(tableName = "incomes",
    foreignKeys = [
        ForeignKey(
            entity = Accounts::class,
            parentColumns = ["accountId"],
            childColumns = ["accountId"],
            onDelete = androidx.room.ForeignKey.CASCADE
        ),
    ],
    indices = [Index(value = ["accountId"])]
)
@Immutable
data class Incomes(
    @PrimaryKey(autoGenerate = true) val incomeId: Int,
    val accountId: Int,
    val incomeType: String,
    val date: OffsetDateTime = OffsetDateTime.now(), // Значение по умолчанию
    val incomesAmount: Double
)
package com.example.moneyflow.data.database.model

import androidx.compose.runtime.Immutable
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.time.OffsetDateTime

@Entity(tableName = "expenses",
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
data class Expenses(
    @PrimaryKey(autoGenerate = true) val expenseId: Int,
    val accountId: Int,
    val date: OffsetDateTime = OffsetDateTime.now(), // Значение по умолчанию
    val expensesType: String,
    val total: Double
)
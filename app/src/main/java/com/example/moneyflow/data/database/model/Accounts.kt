package com.example.moneyflow.data.database.model

import androidx.compose.runtime.Immutable
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "accounts",
    foreignKeys = [
        ForeignKey(
            entity = Assets::class,
            parentColumns = ["assetId"],
            childColumns = ["assetId"],
            onDelete = androidx.room.ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Users::class,
            parentColumns = ["userid"],
            childColumns = ["userid"],
            onDelete = androidx.room.ForeignKey.CASCADE
        )
    ],
    indices = [Index(value = ["assetId", "userid"])]
)
@Immutable
data class Accounts(
    @PrimaryKey(autoGenerate = true) val accountId: Int,
    val assetId: Int,
    val accountsName: String,
    val initialAmount: Double,
    val userid: Int
)
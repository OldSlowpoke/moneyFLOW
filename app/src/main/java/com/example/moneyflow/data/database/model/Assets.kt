package com.example.moneyflow.data.database.model

import androidx.compose.runtime.Immutable
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "assets",
    foreignKeys = [
        ForeignKey(
            entity = Users::class,
            parentColumns = ["userid"],
            childColumns = ["userid"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = AnalyticalReports::class,
            parentColumns = ["assetTypeId"],
            childColumns = ["assetTypeId"],
            onDelete = ForeignKey.CASCADE
        ),
    ],
    indices = [Index(value = ["userid","assetTypeId"])]
)
@Immutable
data class Assets(
    @PrimaryKey(autoGenerate = true) val assetId: Int,
    val userid: Int,
    val accountsId: Int,
    val assetType: String
)
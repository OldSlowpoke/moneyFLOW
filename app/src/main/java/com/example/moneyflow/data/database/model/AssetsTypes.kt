package com.example.moneyflow.data.database.model

import androidx.compose.runtime.Immutable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "assets_types")
@Immutable
data class AssetsTypes(
    @PrimaryKey(autoGenerate = true) val assetTypeId: Int,
    val assetTypeName: String,
    val assetTypeDescription: String
)
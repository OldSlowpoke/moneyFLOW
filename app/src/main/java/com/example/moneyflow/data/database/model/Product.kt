package com.example.moneyflow.data.database.model

import androidx.compose.runtime.Immutable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product")
@Immutable
data class Product(
    @PrimaryKey(autoGenerate = true) val productId: Int,
    val productName: String,
    val productDescription: String,
)
package com.example.moneyflow.data.database.model

import androidx.compose.runtime.Immutable
import androidx.room.Entity
import androidx.room.Index

@Entity(tableName = "product_and_category",
    primaryKeys = ["categoryId", "productId"],
    indices = [Index(value = ["productId","categoryId"])]
)
@Immutable
data class ProductAndCategory(
    val categoryId: Int,
    val productId: Int,
)
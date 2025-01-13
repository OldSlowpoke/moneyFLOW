package com.example.moneyflow.data.database.model

import androidx.compose.runtime.Immutable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product_categories")
@Immutable
data class ProductCategories(
    @PrimaryKey(autoGenerate = true) val categoryId: Int,
    val categoryName: String,
)
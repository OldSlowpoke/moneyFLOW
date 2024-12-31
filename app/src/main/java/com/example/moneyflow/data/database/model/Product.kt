package com.example.moneyflow.data.database.model

import androidx.compose.runtime.Immutable
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "product",
    foreignKeys = [
        ForeignKey(
            entity = ProductCategory::class,
            parentColumns = ["categoryId"],
            childColumns = ["categoryId"],
            onDelete = androidx.room.ForeignKey.CASCADE
        ),
    ],
    indices = [Index(value = ["categoryId"])]
)
@Immutable
data class Product(
    @PrimaryKey(autoGenerate = true) val productId: Int,
    val categoryId: Int,
    val productName: String,
    val productDescription: String,
)
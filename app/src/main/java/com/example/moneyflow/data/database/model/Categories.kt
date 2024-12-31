package com.example.moneyflow.data.database.model

import androidx.compose.runtime.Immutable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categories")
@Immutable
data class Categories(
    @PrimaryKey(autoGenerate = true) val categoryId: Int,
    val categoryName: String,
)
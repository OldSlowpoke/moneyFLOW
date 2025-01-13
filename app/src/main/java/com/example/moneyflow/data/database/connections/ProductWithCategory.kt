package com.example.moneyflow.data.database.connections

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.moneyflow.data.database.model.Product
import com.example.moneyflow.data.database.model.ProductAndCategory
import com.example.moneyflow.data.database.model.ProductCategories

data class ProductWithCategory (
    @Embedded
    val productAndCategory: Product,
    @Relation(
        parentColumn = "productId",
        entityColumn = "categoryId",
        associateBy = Junction(ProductAndCategory::class)
    )
    val product: List<ProductCategories>
)
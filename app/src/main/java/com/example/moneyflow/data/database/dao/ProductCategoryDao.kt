package com.example.moneyflow.data.database.dao

import androidx.room.Dao
import com.example.moneyflow.data.database.model.ProductAndCategory

/**
 * [Room] DAO for [ProductAndCategory] related operations.
 */

@Dao
abstract class ProductCategoryDao : BaseDao<ProductAndCategory> {
}
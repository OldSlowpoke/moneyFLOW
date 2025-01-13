package com.example.moneyflow.data.database.dao

import androidx.room.Dao
import com.example.moneyflow.data.database.model.ProductCategories

/**
 * [Room] DAO for [ProductCategories] related operations.
 */

@Dao
abstract class CategoriesDao : BaseDao<ProductCategories> {
}
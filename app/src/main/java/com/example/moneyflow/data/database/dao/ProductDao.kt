package com.example.moneyflow.data.database.dao

import androidx.room.Dao
import com.example.moneyflow.data.database.model.Product

/**
 * [Room] DAO for [Product] related operations.
 */

@Dao
abstract class ProductDao : BaseDao<Product> {
}
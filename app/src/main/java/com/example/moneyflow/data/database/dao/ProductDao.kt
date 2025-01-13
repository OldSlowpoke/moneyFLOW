package com.example.moneyflow.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.moneyflow.data.database.connections.ProductWithCategory
import com.example.moneyflow.data.database.model.Product

/**
 * [Room] DAO for [Product] related operations.
 */

@Dao
abstract class ProductDao : BaseDao<Product> {
    @Transaction
    @Query(
        """
        SELECT * FROM incomes
        """
    )
    abstract fun GetAllIncomes(): LiveData<List<ProductWithCategory>>
}
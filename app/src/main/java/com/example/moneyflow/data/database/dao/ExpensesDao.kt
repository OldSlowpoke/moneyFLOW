package com.example.moneyflow.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.moneyflow.data.database.connections.ExpenseWithProduct
import com.example.moneyflow.data.database.model.Expenses

/**
 * [Room] DAO for [Expenses] related operations.
 */

@Dao
abstract class ExpensesDao : BaseDao<Expenses> {
    @Query(
        """
        SELECT * FROM expenses
        """
    )
    abstract fun GetLastthirtyExpenses(
        limit: Int
    ): LiveData<List<ExpenseWithProduct>>
}
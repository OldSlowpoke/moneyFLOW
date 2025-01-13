package com.example.moneyflow.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.moneyflow.data.database.connections.ExpenseWithProduct
import com.example.moneyflow.data.database.model.Expenses

/**
 * [Room] DAO for [Expenses] related operations.
 */

@Dao
abstract class ExpensesDao : BaseDao<Expenses> {
    @Transaction
    @Query(
        """
        SELECT * FROM expenses
        WHERE date BETWEEN :startDate AND :endDate
        """
    )
    abstract fun getExpensesBetweenDates(
        startDate: String,
        endDate: String
    ): LiveData<List<ExpenseWithProduct>>

    @Transaction
    @Query(
        """
        SELECT * FROM expenses
        ORDER BY date DESC
        LIMIT 30
        """
    )
    abstract fun getLastThirtyExpenses(): LiveData<List<ExpenseWithProduct>>

    @Transaction
    @Query(
        """
        SELECT * FROM expenses
        """
    )
    abstract fun GetAllExpenses(): LiveData<List<ExpenseWithProduct>>
}
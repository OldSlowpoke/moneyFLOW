package com.example.moneyflow.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.moneyflow.data.database.model.Incomes

/**
 * [Room] DAO for [Incomes] related operations.
 */

@Dao
abstract class IncomesDao : BaseDao<Incomes> {
    @Transaction
    @Query(
        """
        SELECT * FROM incomes
        """
    )
    abstract fun getAllIncomes(): LiveData<List<IncomensWithType>>

    @Transaction
    @Query(
        """
        SELECT * FROM incomes
        WHERE date BETWEEN :startDate AND :endDate
        """
    )
    abstract fun getIncomesBetweenDates(
        startDate: String,
        endDate: String
    ): LiveData<List<IncomensWithType>>

    @Transaction
    @Query(
        """
        SELECT * FROM incomes
        ORDER BY date DESC
        LIMIT 30
        """
    )
    abstract fun getLastThirtyIncomes(): LiveData<List<IncomensWithType>>
}
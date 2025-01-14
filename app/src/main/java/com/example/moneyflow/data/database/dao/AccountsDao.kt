package com.example.moneyflow.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.moneyflow.data.database.model.Accounts
import com.example.moneyflow.data.database.model.Users

/**
 * [Room] DAO for [Users] related operations.
 */

@Dao
abstract class AccountsDao : BaseDao<Accounts> {
    @Transaction
    @Query(
        """
        SELECT
            COALESCE((SELECT SUM(initialAmount) FROM Accounts), 0) +
            COALESCE((SELECT SUM(incomesAmount) FROM Incomes), 0) -
            COALESCE((SELECT SUM(total) FROM Expenses), 0) AS totalBalance
        FROM Accounts
        """
    )
    abstract fun getBalance(): LiveData<Double>
}


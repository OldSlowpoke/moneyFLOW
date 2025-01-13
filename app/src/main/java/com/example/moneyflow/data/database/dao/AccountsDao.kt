package com.example.moneyflow.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.moneyflow.data.database.connections.ExpenseWithProduct
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
            COALESCE(SUM(initialAmount), 0) +
            COALESCE((SELECT SUM(incomesAmount) FROM Incomes), 0) -
            COALESCE((SELECT SUM(total) FROM ReceiptItem JOIN Expenses ON ReceiptItem.expenseId = Expenses.expenseId), 0) AS totalBalance
        FROM Accounts
        """
    )
    abstract fun getBalance(): LiveData<Double>
}


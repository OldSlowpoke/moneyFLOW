package com.example.moneyflow.data.database.dao

import androidx.room.Dao
import com.example.moneyflow.data.database.model.ExpenseTypes


/**
 * [Room] DAO for [ExpenseTypes] related operations.
 */

@Dao
abstract class ExpenseTypesDao : BaseDao<ExpenseTypes> {
}
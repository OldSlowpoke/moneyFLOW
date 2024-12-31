package com.example.moneyflow.data.database.dao

import androidx.room.Dao
import com.example.moneyflow.data.database.model.Incomes

/**
 * [Room] DAO for [Incomes] related operations.
 */

@Dao
abstract class IncomesDao : BaseDao<Incomes> {
}
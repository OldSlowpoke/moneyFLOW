package com.example.moneyflow.data.database.dao

import androidx.room.Dao
import com.example.moneyflow.data.database.model.IncomeTypes

/**
 * [Room] DAO for [IncomeTypes] related operations.
 */

@Dao
abstract class IncomeTypesDao : BaseDao<IncomeTypes> {
}
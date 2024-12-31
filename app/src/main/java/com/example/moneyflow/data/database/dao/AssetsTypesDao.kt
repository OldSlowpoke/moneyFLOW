package com.example.moneyflow.data.database.dao

import androidx.room.Dao
import com.example.moneyflow.data.database.model.AssetsTypes

/**
 * [Room] DAO for [AssetsTypes] related operations.
 */

@Dao
abstract class AssetsTypesDao : BaseDao<AssetsTypes> {
}
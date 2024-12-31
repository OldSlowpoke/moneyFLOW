package com.example.moneyflow.data.database.dao

import androidx.room.Dao
import com.example.moneyflow.data.database.model.Assets

/**
 * [Room] DAO for [Assets] related operations.
 */

@Dao
abstract class AssetsDao : BaseDao<Assets> {
}
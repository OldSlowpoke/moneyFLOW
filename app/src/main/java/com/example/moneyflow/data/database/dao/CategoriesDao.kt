package com.example.moneyflow.data.database.dao

import androidx.room.Dao
import com.example.moneyflow.data.database.model.Categories

/**
 * [Room] DAO for [Categories] related operations.
 */

@Dao
abstract class CategoriesDao : BaseDao<Categories> {
}
package com.example.moneyflow.data.database.dao

import androidx.room.Dao
import com.example.moneyflow.data.database.model.Accounts
import com.example.moneyflow.data.database.model.Users

/**
 * [Room] DAO for [Users] related operations.
 */

@Dao
abstract class AccountsDao : BaseDao<Accounts> {
}


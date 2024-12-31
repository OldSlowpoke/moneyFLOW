package com.example.moneyflow.data.database.dao

import androidx.room.Dao
import com.example.moneyflow.data.database.model.ReceiptItem

/**
 * [Room] DAO for [ReceiptItem] related operations.
 */

@Dao
abstract class ReceiptItemDao : BaseDao<ReceiptItem> {
}
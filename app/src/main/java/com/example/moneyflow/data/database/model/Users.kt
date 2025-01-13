package com.example.moneyflow.data.database.model
import androidx.compose.runtime.Immutable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
@Immutable
data class Users(
    @PrimaryKey(autoGenerate = true) val userid: Int,
    val username: String,
    val birthdate: String,
) {

}
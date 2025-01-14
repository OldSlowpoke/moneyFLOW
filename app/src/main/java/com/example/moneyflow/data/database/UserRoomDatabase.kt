package com.example.moneyflow.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.moneyflow.data.database.dao.AccountsDao
import com.example.moneyflow.data.database.dao.AnalyticalReportsDao
import com.example.moneyflow.data.database.dao.AssetsDao
import com.example.moneyflow.data.database.dao.CategoriesDao
import com.example.moneyflow.data.database.dao.ExpensesDao
import com.example.moneyflow.data.database.dao.IncomesDao
import com.example.moneyflow.data.database.dao.ProductCategoryDao
import com.example.moneyflow.data.database.dao.ProductDao
import com.example.moneyflow.data.database.dao.ReceiptItemDao
import com.example.moneyflow.data.database.dao.UnitsOfMeasurementDao
import com.example.moneyflow.data.database.dao.UsersDao
import com.example.moneyflow.data.database.model.Accounts
import com.example.moneyflow.data.database.model.AnalyticalReports
import com.example.moneyflow.data.database.model.Assets
import com.example.moneyflow.data.database.model.ProductCategories
import com.example.moneyflow.data.database.model.Expenses
import com.example.moneyflow.data.database.model.Incomes
import com.example.moneyflow.data.database.model.Product
import com.example.moneyflow.data.database.model.ProductAndCategory
import com.example.moneyflow.data.database.model.ReceiptItem
import com.example.moneyflow.data.database.model.UnitsOfMeasurement
import com.example.moneyflow.data.database.model.Users

@Database(entities = [(Users::class),
    (Accounts::class),
    (AnalyticalReports::class),
    (Assets::class),
    (ProductCategories::class),
    (Expenses::class),
    (Incomes::class),
    (Product::class),
    (ProductAndCategory::class),
    (ReceiptItem::class),
    (UnitsOfMeasurement::class),
    ],
    version = 1,
    exportSchema = false,
)
@TypeConverters(DateTimeTypeConverters::class)
abstract class UserRoomDatabase: RoomDatabase() {

    abstract fun userDao(): UsersDao
    abstract fun analyticalReportsDao(): AnalyticalReportsDao
    abstract fun assetsDao(): AssetsDao
    abstract fun categoriesDao(): CategoriesDao
    abstract fun expensesDao(): ExpensesDao
    abstract fun incomesDao(): IncomesDao
    abstract fun productsDao(): ProductDao
    abstract fun productCategoryDao(): ProductCategoryDao
    abstract fun receiptItemsDao(): ReceiptItemDao
    abstract fun unitsOfMeasurementDao(): UnitsOfMeasurementDao
    abstract fun accountsDao(): AccountsDao

    // реализуем синглтон
    companion object {
        private var INSTANCE: UserRoomDatabase? = null
        fun getInstance(context: Context): UserRoomDatabase {

            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        UserRoomDatabase::class.java,
                        "moneyFlowDB"
                    ).fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
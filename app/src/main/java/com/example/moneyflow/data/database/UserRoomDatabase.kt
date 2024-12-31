package com.example.moneyflow.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.moneyflow.data.database.dao.AccountsDao
import com.example.moneyflow.data.database.dao.AnalyticalReportsDao
import com.example.moneyflow.data.database.dao.AssetsDao
import com.example.moneyflow.data.database.dao.AssetsTypesDao
import com.example.moneyflow.data.database.dao.CategoriesDao
import com.example.moneyflow.data.database.dao.ExpenseTypesDao
import com.example.moneyflow.data.database.dao.ExpensesDao
import com.example.moneyflow.data.database.dao.IncomeTypesDao
import com.example.moneyflow.data.database.dao.IncomesDao
import com.example.moneyflow.data.database.dao.ProductCategoryDao
import com.example.moneyflow.data.database.dao.ProductDao
import com.example.moneyflow.data.database.dao.ReceiptItemDao
import com.example.moneyflow.data.database.dao.UnitsOfMeasurementDao
import com.example.moneyflow.data.database.dao.UsersDao
import com.example.moneyflow.data.database.model.Accounts
import com.example.moneyflow.data.database.model.AnalyticalReports
import com.example.moneyflow.data.database.model.Assets
import com.example.moneyflow.data.database.model.AssetsTypes
import com.example.moneyflow.data.database.model.Categories
import com.example.moneyflow.data.database.model.ExpenseTypes
import com.example.moneyflow.data.database.model.Expenses
import com.example.moneyflow.data.database.model.IncomeTypes
import com.example.moneyflow.data.database.model.Incomes
import com.example.moneyflow.data.database.model.Product
import com.example.moneyflow.data.database.model.ProductCategory
import com.example.moneyflow.data.database.model.ReceiptItem
import com.example.moneyflow.data.database.model.UnitsOfMeasurement
import com.example.moneyflow.data.database.model.Users

@Database(entities = [(Users::class),
    (Accounts::class),
    (AnalyticalReports::class),
    (Assets::class),
    (Categories::class),
    (Expenses::class),
    (ExpenseTypes::class),
    (Incomes::class),
    (IncomeTypes::class),
    (Product::class),
    (ProductCategory::class),
    (ReceiptItem::class),
    (UnitsOfMeasurement::class),
    (AssetsTypes::class)
    ],
    version = 1
)
abstract class UserRoomDatabase: RoomDatabase() {

    abstract fun userDao(): UsersDao
    abstract fun analyticalReportsDao(): AnalyticalReportsDao
    abstract fun assetsDao(): AssetsDao
    abstract fun categoriesDao(): CategoriesDao
    abstract fun expensesDao(): ExpensesDao
    abstract fun expenseTypesDao(): ExpenseTypesDao
    abstract fun incomesDao(): IncomesDao
    abstract fun incomeTypesDao(): IncomeTypesDao
    abstract fun productsDao(): ProductDao
    abstract fun productCategoryDao(): ProductCategoryDao
    abstract fun receiptItemsDao(): ReceiptItemDao
    abstract fun unitsOfMeasurementDao(): UnitsOfMeasurementDao
    abstract fun assetsTypesDao(): AssetsTypesDao
    abstract fun accacoutsDao(): AccountsDao

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
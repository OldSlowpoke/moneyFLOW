package com.example.moneyflow.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {
    @Insert
    suspend fun insert(user: User)

    @Query("SELECT * FROM users")
    fun getAllUsers(): LiveData<List<User>>

    @Query("SELECT * FROM users WHERE userId = :id")
    suspend fun getUserById(id: Int): User
}

@Dao
interface AssetTypeDao {
    @Insert
    suspend fun insert(assetType: AssetType)

    @Query("SELECT * FROM asset_types")
    fun getAllAssetTypes(): LiveData<List<AssetType>>
}

@Dao
interface AssetDao {
    @Insert
    suspend fun insert(asset: Asset)

    @Query("SELECT * FROM assets")
    fun getAllAssets(): LiveData<List<Asset>>
}

@Dao
interface AccountDao {
    @Insert
    suspend fun insert(account: Account)

    @Query("SELECT * FROM accounts")
    fun getAllAccounts(): LiveData<List<Account>>
}

@Dao
interface AnalyticReportDao {
    @Insert
    suspend fun insert(report: AnalyticReport)

    @Query("SELECT * FROM analytic_reports")
    fun getAllReports(): LiveData<List<AnalyticReport>>
}

@Dao
interface ExpenseTypeDao {
    @Insert
    suspend fun insert(expenseType: ExpenseType)

    @Query("SELECT * FROM expense_types")
    fun getAllExpenseTypes(): LiveData<List<ExpenseType>>
}

@Dao
interface ExpenseDao {
    @Insert
    suspend fun insert(expense: Expense)

    @Query("SELECT * FROM expenses")
    fun getAllExpenses(): LiveData<List<Expense>>

    @Query("SELECT * FROM expenses WHERE date BETWEEN :startDate AND :endDate")
    fun getExpensesByDateRange(startDate: String, endDate: String): LiveData<List<Expense>>
}

@Dao
interface IncomeTypeDao {
    @Insert
    suspend fun insert(incomeType: IncomeType)

    @Query("SELECT * FROM income_types")
    fun getAllIncomeTypes(): LiveData<List<IncomeType>>
}

@Dao
interface IncomeDao {
    @Insert
    suspend fun insert(income: Income)

    @Query("SELECT * FROM incomes")
    fun getAllIncomes(): LiveData<List<Income>>
}

@Dao
interface ReceiptDao {
    @Insert
    suspend fun insert(receipt: Receipt)

    @Query("SELECT * FROM receipts")
    fun getAllReceipts(): LiveData<List<Receipt>>
}

@Dao
interface ItemDao {
    @Insert
    suspend fun insert(item: Item)

    @Query("SELECT * FROM items")
    fun getAllItems(): LiveData<List<Item>>
}

@Dao
interface ProductDao {
    @Insert
    suspend fun insert(product: Product)

    @Query("SELECT * FROM products")
    fun getAllProducts(): LiveData<List<Product>>
}

@Dao
interface UnitOfMeasureDao {
    @Insert
    suspend fun insert(unit: UnitOfMeasure)

    @Query("SELECT * FROM units_of_measure")
    fun getAllUnits(): LiveData<List<UnitOfMeasure>>
}

@Dao
interface CategoryDao {
    @Insert
    suspend fun insert(category: Category)

    @Query("SELECT * FROM categories")
    fun getAllCategories(): LiveData<List<Category>>
}

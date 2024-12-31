package com.example.moneyflow.data.database.model

import androidx.lifecycle.LiveData
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import androidx.room.Relation

/*
@Entity(tableName = "users")
data class Users(
    @PrimaryKey(autoGenerate = true) val userid: Int,
    val username: String,
    val password: String,
    val logger: String,
    val birthdate: String,
)

@Entity(tableName = "assetsTypes")
data class AssetsTypes(
    @PrimaryKey(autoGenerate = true) val assetTypeId: Int,
    val assetTypeName: String,
    val assetTypeDescription: String
)

@Entity(tableName = "assets",
    foreignKeys = [
        ForeignKey(
            entity = AnalyticalReports::class,
            parentColumns = kotlin.arrayOf("userid"),
            childColumns = kotlin.arrayOf("userid"),
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = AnalyticalReports::class,
            parentColumns = kotlin.arrayOf("assetTypeId"),
            childColumns = kotlin.arrayOf("assetTypeId"),
            onDelete = ForeignKey.CASCADE
        ),
    ],
    indices = [Index(value = ["userid","assetTypeId"])]
)
data class Assets(
    @PrimaryKey(autoGenerate = true) val assetId: Int,
    val userid: Int,
    val accountsId: Int,
    val assetTypeId: Int
)

@Entity(tableName = "accounts",
    foreignKeys = [
        ForeignKey(
            entity = Assets::class,
            parentColumns = kotlin.arrayOf("assetId"),
            childColumns = kotlin.arrayOf("assetId"),
            onDelete = androidx.room.ForeignKey.CASCADE
        ),
    ],
    indices = [Index(value = ["assetId"])]
)
data class Accounts(
    @PrimaryKey(autoGenerate = true) val accountId: Int,
    val assetId: Int,
    val accountsName: String,
    val initialAmount: Double
)

@Entity(tableName = "analyticalReports",
    foreignKeys = [
        ForeignKey(
            entity = Users::class,
            parentColumns = kotlin.arrayOf("userid"),
            childColumns = kotlin.arrayOf("userid"),
            onDelete = androidx.room.ForeignKey.CASCADE
        ),
    ],
    indices = [Index(value = ["userid"])]
)
data class AnalyticalReports(
    @PrimaryKey(autoGenerate = true) val analyticalReportId: Int,
    val userid: Int,
    val date: String,
    val spendingAmount: Double,
    val incomeAmount: Double,
    val numberOfAmount: Int,
    val numberOfIncomes: Int
)

@Entity(tableName = "expenses",
    foreignKeys = [
        ForeignKey(
            entity = Accounts::class,
            parentColumns = kotlin.arrayOf("accountId"),
            childColumns = kotlin.arrayOf("accountId"),
            onDelete = androidx.room.ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = ExpenseTypes::class,
            parentColumns = kotlin.arrayOf("expenseTypeId"),
            childColumns = kotlin.arrayOf("expenseTypeId"),
            onDelete = androidx.room.ForeignKey.CASCADE
        ),
    ],
    indices = [Index(value = ["accountId","incomeTypeId"])]
)
data class Expenses(
    @PrimaryKey(autoGenerate = true) val expenseId: Int,
    val accountsId: Int,
    val date: String,
    val expensesType: Int,
)

@Entity(tableName = "incomes",
    foreignKeys = [
        ForeignKey(
            entity = Accounts::class,
            parentColumns = kotlin.arrayOf("accountId"),
            childColumns = kotlin.arrayOf("accountId"),
            onDelete = androidx.room.ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = IncomeTypes::class,
            parentColumns = kotlin.arrayOf("incomeTypeId"),
            childColumns = kotlin.arrayOf("incomeTypeId"),
            onDelete = androidx.room.ForeignKey.CASCADE
        ),
    ],
    indices = [Index(value = ["accountId","incomeTypeId"])]
)
data class Incomes(
    @PrimaryKey(autoGenerate = true) val incomeId: Int,
    val accountsId: Int,
    val incomeTypeId: Int,
    val date: String,
    val incomesAmount: Double
)

@Entity(tableName = "incomeTypes")
data class IncomeTypes(
    @PrimaryKey(autoGenerate = true) val incomeTypeId: Int,
    val incomeTypeNumber: String,
    val incomeTypeDescription: String
)

@Entity(tableName = "expenseTypes")
data class ExpenseTypes(
    @PrimaryKey(autoGenerate = true) val expenseTypeId: Int,
    val expenseTypeNumber: String,
    val expenseTypeDescription: String
)

@Entity(tableName = "receiptItem",
    foreignKeys = [
        ForeignKey(
            entity = Expenses::class,
            parentColumns = kotlin.arrayOf("expenseId"),
            childColumns = kotlin.arrayOf("expenseId"),
            onDelete = androidx.room.ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = UnitsOfMeasurement::class,
            parentColumns = kotlin.arrayOf("unitId"),
            childColumns = kotlin.arrayOf("unitId"),
            onDelete = androidx.room.ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Product::class,
            parentColumns = kotlin.arrayOf("productId"),
            childColumns = kotlin.arrayOf("productId"),
            onDelete = androidx.room.ForeignKey.CASCADE
        ),
    ],
    indices = [Index(value = ["productId","unitId","expenseId"])]
)
data class ReceiptItem(
    val expenseId: Int,
    val productId: Int,
    val unitId: Int,
    val pricePerUnit: Double,
    val quantity: Int,
    val discount: Boolean,
    val total: Double
)

@Entity(tableName = "product",
    foreignKeys = [
        ForeignKey(
            entity = ProductCategory::class,
            parentColumns = kotlin.arrayOf("categoryId"),
            childColumns = kotlin.arrayOf("categoryId"),
            onDelete = androidx.room.ForeignKey.CASCADE
        ),
    ],
    indices = [Index(value = ["categoryId"])]
)
data class Product(
    @PrimaryKey(autoGenerate = true) val productId: Int,
    val categoryId: Int,
    val productName: String,
    val productDescription: String,
)

@Entity(tableName = "productCategory",
    primaryKeys = ["categoryId", "productId"],
    foreignKeys = [
        ForeignKey(
            entity = Product::class,
            parentColumns = kotlin.arrayOf("productId"),
            childColumns = kotlin.arrayOf("productId"),
            onDelete = androidx.room.ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Categories::class,
            parentColumns = kotlin.arrayOf("categoryId"),
            childColumns = kotlin.arrayOf("categoryId"),
            onDelete = androidx.room.ForeignKey.CASCADE
        ),
    ],
    indices = [Index(value = ["productId","categoryId"])]
)
data class ProductCategory(
    val categoryId: Int,
    val productId: Int,
)

@Entity(tableName = "categories")
data class Categories(
    @PrimaryKey(autoGenerate = true) val categoryId: Int,
    val categoryName: String,
)

@Entity(tableName = "unitsOfMeasurement")
data class UnitsOfMeasurement(
    @PrimaryKey(autoGenerate = true) val unitId: Int,
    val unitName: String,
)

*/

data class UserWithAnalyticReport(
    @Embedded val users: Users,
    @Relation(
        parentColumn = "userid",
        entityColumn = "userid"
    )
    val analyticReport: List<AnalyticalReports>
)

data class UserWithExpenses(
    @Embedded val users: Users,
    @Relation(
        parentColumn = "userid",
        entityColumn = "userid"
    )
    val expenses: List<Expenses>
)

data class AssetWhitAccount(
    @Embedded val assets: Assets,
    @Relation(
        parentColumn = "assetId",
        entityColumn = "assetId"
    )
    val account: List<Accounts>
)
 data class AssetsTypesWithAssets(
     @Embedded val assetsTypes: AssetsTypes,
     @Relation(
         parentColumn = "assetTypeId",
         entityColumn = "assetTypeId"
     )
     val assets: Assets
 )


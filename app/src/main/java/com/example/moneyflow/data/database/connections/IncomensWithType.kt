package com.example.moneyflow.data.database.connections

import androidx.room.Embedded
import androidx.room.Relation
import com.example.moneyflow.data.database.model.IncomeTypes
import com.example.moneyflow.data.database.model.Incomes

class IncomensWithType (
    @Embedded
    val incomeTypes: IncomeTypes,

    @Relation(
        parentColumn = "incomeTypeId",
        entityColumn = "incomeTypeId",
    )
    val incomes: Incomes
)
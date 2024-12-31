package com.example.moneyflow.data.database.connections

import androidx.room.Embedded
import androidx.room.Relation
import com.example.moneyflow.data.database.model.IncomeTypes
import com.example.moneyflow.data.database.model.Incomes
import java.util.Objects

class IncomensesWithType {
    @Embedded
    lateinit var incomeTypes: IncomeTypes

    @Relation(
        parentColumn = "incomeTypeId",
        entityColumn = "incomeTypeId"
    )
    lateinit var incomes: Incomes

    override fun equals(other: Any?): Boolean = when {
        other === this -> true
        other is IncomensesWithType -> incomeTypes == other.incomeTypes && incomes == other.incomes
        else -> false
    }

    override fun hashCode(): Int = Objects.hash(incomeTypes, incomes)
}
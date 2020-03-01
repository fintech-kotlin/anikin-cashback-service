package ru.tinkoff.fintech.service.cashback

import ru.tinkoff.fintech.model.TransactionInfo
import ru.tinkoff.fintech.service.cashback.program.*
import ru.tinkoff.fintech.utils.roundSum

internal const val LOYALTY_PROGRAM_BLACK = "BLACK"
internal const val LOYALTY_PROGRAM_ALL = "ALL"
internal const val LOYALTY_PROGRAM_BEER = "BEER"
internal const val MAX_CASH_BACK = 3000.0
internal const val MCC_SOFTWARE = 5734
internal const val MCC_BEER = 5921

class CashbackCalculatorImpl : CashbackCalculator {

    override fun calculateCashback(transactionInfo: TransactionInfo): Double = roundSum(
        MaxCashbackProgramDecorator(
            EvilProgramDecorator(
                when (transactionInfo.loyaltyProgramName) {
                    LOYALTY_PROGRAM_BLACK -> BlackProgram()
                    LOYALTY_PROGRAM_BEER -> BeerProgram()
                    LOYALTY_PROGRAM_ALL -> AllProgram()
                    else -> throw IllegalArgumentException("Program not found")
                }
            )
        ).calculateCashback(transactionInfo)
    )
}
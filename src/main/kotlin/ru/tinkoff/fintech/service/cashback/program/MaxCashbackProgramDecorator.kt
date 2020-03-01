package ru.tinkoff.fintech.service.cashback.program

import ru.tinkoff.fintech.model.TransactionInfo
import ru.tinkoff.fintech.service.cashback.MAX_CASH_BACK

class MaxCashbackProgramDecorator(private val program: Program): Program {
    override fun calculateCashback(transactionInfo: TransactionInfo): Double {
        val result = program.calculateCashback(transactionInfo)
        return if (transactionInfo.cashbackTotalValue + result > MAX_CASH_BACK) {
            MAX_CASH_BACK - transactionInfo.cashbackTotalValue
        } else {
            result
        }
    }

}
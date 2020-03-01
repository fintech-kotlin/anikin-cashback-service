package ru.tinkoff.fintech.service.cashback.program

import ru.tinkoff.fintech.model.TransactionInfo
import ru.tinkoff.fintech.utils.roundSum

class BlackProgram : Program {
    override fun calculateCashback(transactionInfo: TransactionInfo): Double =
        roundSum(transactionInfo.transactionSum / 100)
}
package ru.tinkoff.fintech.service.cashback.program

import ru.tinkoff.fintech.model.TransactionInfo

internal const val EVIL_NUMBER = 666
internal const val EVIL_CASHBACK = 6.66

class EvilProgramDecorator(private val program: Program) : Program {
    override fun calculateCashback(transactionInfo: TransactionInfo): Double =
        if (transactionInfo.transactionSum % EVIL_NUMBER == 0.0) {
            program.calculateCashback(transactionInfo) + EVIL_CASHBACK;
        } else {
            program.calculateCashback(transactionInfo)
        }
}
package ru.tinkoff.fintech.service.cashback.program

import ru.tinkoff.fintech.model.TransactionInfo

interface Program {
    fun calculateCashback(transactionInfo: TransactionInfo) : Double
}
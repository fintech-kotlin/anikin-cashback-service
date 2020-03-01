package ru.tinkoff.fintech.service.cashback.program

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ru.tinkoff.fintech.model.TransactionInfo
import ru.tinkoff.fintech.service.cashback.LOYALTY_PROGRAM_BLACK

class BlackProgramTest {

    private val observable = BlackProgram()

    @Test
    fun `cashBack is equals 10 for first transaction sum 1000 and black loyalty program`() {
        val transactionInfo = TransactionInfo(
            loyaltyProgramName = LOYALTY_PROGRAM_BLACK,
            transactionSum = 1000.0,
            cashbackTotalValue = 0.0,
            firstName = "testFirstName",
            lastName = "testLastName"
        )
        val cashbackSum = observable.calculateCashback(transactionInfo)
        Assertions.assertEquals(10.0, cashbackSum)
    }

    @Test
    fun `cashBack is equals 11,11 for transaction sum 1111,11 and black loyalty program`() {
        val transactionInfo = TransactionInfo(
            loyaltyProgramName = LOYALTY_PROGRAM_BLACK,
            transactionSum = 1111.11,
            cashbackTotalValue = 0.0,
            firstName = "testFirstName",
            lastName = "testLastName"
        )
        val cashbackSum = observable.calculateCashback(transactionInfo)
        Assertions.assertEquals(11.11, cashbackSum)
    }

}
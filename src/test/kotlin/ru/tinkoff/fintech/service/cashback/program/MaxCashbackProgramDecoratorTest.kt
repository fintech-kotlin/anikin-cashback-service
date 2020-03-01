package ru.tinkoff.fintech.service.cashback.program

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ru.tinkoff.fintech.model.TransactionInfo
import ru.tinkoff.fintech.service.cashback.LOYALTY_PROGRAM_BLACK

class MaxCashbackProgramDecoratorTest {

    private val observable = MaxCashbackProgramDecorator(BlackProgram())

    @Test
    fun `cashBack is equals 10 for cashback limit 1000`() {
        val transactionInfo = TransactionInfo(
            loyaltyProgramName = LOYALTY_PROGRAM_BLACK,
            transactionSum = 1000.0,
            cashbackTotalValue = 1000.0,
            firstName = "testFirstName",
            lastName = "testLastName"
        )
        val cashbackSum = observable.calculateCashback(transactionInfo)
        Assertions.assertEquals(10.0, cashbackSum)
    }

    @Test
    fun `cashBack is equals 0 for cashback limit`() {
        val transactionInfo = TransactionInfo(
            loyaltyProgramName = LOYALTY_PROGRAM_BLACK,
            transactionSum = 1000.0,
            cashbackTotalValue = 3000.0,
            firstName = "testFirstName",
            lastName = "testLastName"
        )
        val cashbackSum = observable.calculateCashback(transactionInfo)
        Assertions.assertEquals(0.0, cashbackSum)
    }

    @Test
    fun `cashBack is equals 3 for cashback limit 2997`() {
        val transactionInfo = TransactionInfo(
            loyaltyProgramName = LOYALTY_PROGRAM_BLACK,
            transactionSum = 1000.0,
            cashbackTotalValue = 2997.0,
            firstName = "testFirstName",
            lastName = "testLastName"
        )
        val cashbackSum = observable.calculateCashback(transactionInfo)
        Assertions.assertEquals(3.0, cashbackSum)
    }


}
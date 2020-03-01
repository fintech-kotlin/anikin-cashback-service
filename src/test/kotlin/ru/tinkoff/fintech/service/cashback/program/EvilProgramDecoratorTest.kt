package ru.tinkoff.fintech.service.cashback.program

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ru.tinkoff.fintech.model.TransactionInfo
import ru.tinkoff.fintech.service.cashback.LOYALTY_PROGRAM_BLACK

class EvilProgramDecoratorTest {

    private val observable = EvilProgramDecorator(BlackProgram())

    @Test
    fun `cash back for sums divisible on 666 increases on 6,66 1`() {
        val transactionInfo = TransactionInfo(
            loyaltyProgramName = LOYALTY_PROGRAM_BLACK,
            transactionSum = 666.0,
            cashbackTotalValue = 1000.0,
            firstName = "testFirstName",
            lastName = "testLastName"
        )
        val cashbackSum = observable.calculateCashback(transactionInfo)
        Assertions.assertEquals(13.32, cashbackSum)
    }


    @Test
    fun `cash back for sums divisible on 666 increases on 6,66 2`() {
        val transactionInfo = TransactionInfo(
            loyaltyProgramName = LOYALTY_PROGRAM_BLACK,
            transactionSum = 1332.0,
            cashbackTotalValue = 1000.0,
            firstName = "testFirstName",
            lastName = "testLastName"
        )
        val cashbackSum = observable.calculateCashback(transactionInfo)
        Assertions.assertEquals(19.98, cashbackSum)
    }

}
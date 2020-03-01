package ru.tinkoff.fintech.service.cashback.program

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ru.tinkoff.fintech.model.TransactionInfo
import ru.tinkoff.fintech.service.cashback.LOYALTY_PROGRAM_ALL
import ru.tinkoff.fintech.service.cashback.MCC_SOFTWARE

class AllProgramTest {

    private val observable = AllProgram()

    @Test
    fun `cash back for palindrome sums with one replace and mcc = 5734 and loyalty ALL`() {
        val transactionInfo = TransactionInfo(
            loyaltyProgramName = LOYALTY_PROGRAM_ALL,
            transactionSum = 100_000.0,
            cashbackTotalValue = 0.0,
            firstName = "Ева",
            lastName = "Охоцимская",
            mccCode = MCC_SOFTWARE
        )
        val cashbackSum = observable.calculateCashback(transactionInfo)
        Assertions.assertEquals(30.0, cashbackSum)
    }

    @Test
    fun `cash back for palindrome sums with one replace and mcc = 5734 and loyalty ALL 2`() {
        val transactionInfo = TransactionInfo(
            loyaltyProgramName = LOYALTY_PROGRAM_ALL,
            transactionSum = 10_000.0,
            cashbackTotalValue = 0.0,
            firstName = "Дмитрий",
            lastName = "Масалимов",
            mccCode = MCC_SOFTWARE
        )
        val cashbackSum = observable.calculateCashback(transactionInfo)
        Assertions.assertEquals(6.3, cashbackSum)
    }

    @Test
    fun `cash back for palindrome sums with one replace and mcc = 5734 and loyalty ALL 3`() {
        val transactionInfo = TransactionInfo(
            loyaltyProgramName = LOYALTY_PROGRAM_ALL,
            transactionSum = 50_000.0,
            cashbackTotalValue = 2500.0,
            firstName = "Лиза",
            lastName = "Кразаева",
            mccCode = MCC_SOFTWARE
        )
        val cashbackSum = observable.calculateCashback(transactionInfo)
        Assertions.assertEquals(4.0, cashbackSum)
    }

    @Test
    fun `cash back for palindrome sums with one replace and mcc = 5734 and loyalty ALL 4`() {
        val transactionInfo = TransactionInfo(
            loyaltyProgramName = LOYALTY_PROGRAM_ALL,
            transactionSum = 12_222.20,
            cashbackTotalValue = 2000.0,
            firstName = "Валентина",
            lastName = "Клинешнева",
            mccCode = MCC_SOFTWARE
        )
        val cashbackSum = observable.calculateCashback(transactionInfo)
        Assertions.assertEquals(11.0, cashbackSum)
    }

    @Test
    fun `cash back for palindrome sums with one replace and mcc = 5734 and loyalty ALL 5`() {
        val transactionInfo = TransactionInfo(
            loyaltyProgramName = LOYALTY_PROGRAM_ALL,
            transactionSum = 12252.21,
            cashbackTotalValue = 2000.0,
            firstName = "Валентина",
            lastName = "Клинешнева",
            mccCode = MCC_SOFTWARE
        )
        val cashbackSum = observable.calculateCashback(transactionInfo)
        Assertions.assertEquals(11.03, cashbackSum)
    }

    @Test
    fun `cash back for palindrome sums with one replace and mcc = 5734 and loyalty ALL limited by max cash back`() {
        val transactionInfo = TransactionInfo(
            loyaltyProgramName = LOYALTY_PROGRAM_ALL,
            transactionSum = 100_000.0,
            cashbackTotalValue = 0.0,
            firstName = "Дмитрий",
            lastName = "Масалимов",
            mccCode = MCC_SOFTWARE
        )
        val cashbackSum = observable.calculateCashback(transactionInfo)
        Assertions.assertEquals(63.0, cashbackSum)
    }

    @Test
    fun `cash back for palindrome sums with one replace with random mcc and loyalty ALL limited by max cash back`() {
        val transactionInfo = TransactionInfo(
            loyaltyProgramName = LOYALTY_PROGRAM_ALL,
            transactionSum = 50_000.0,
            cashbackTotalValue = 2500.0,
            firstName = "Лиза",
            lastName = "Кразаева",
            mccCode = 1234
        )
        val cashbackSum = observable.calculateCashback(transactionInfo)
        Assertions.assertEquals(0.0, cashbackSum)
    }

    @Test
    fun `cash back for palindrome sums with two replace and mcc = 5734 and loyalty ALL 1`() {
        val transactionInfo = TransactionInfo(
            loyaltyProgramName = LOYALTY_PROGRAM_ALL,
            transactionSum = 122522.1,
            cashbackTotalValue = 2000.0,
            firstName = "Валентина",
            lastName = "Клинешнева",
            mccCode = MCC_SOFTWARE
        )
        val cashbackSum = observable.calculateCashback(transactionInfo)
        Assertions.assertEquals(0.0, cashbackSum)
    }

    @Test
    fun `cash back for palindrome sums with two replace and mcc = 5734 and loyalty ALL 2`() {
        val transactionInfo = TransactionInfo(
            loyaltyProgramName = LOYALTY_PROGRAM_ALL,
            transactionSum = 1226552.20,
            cashbackTotalValue = 2000.0,
            firstName = "Валентина",
            lastName = "Клинешнева",
            mccCode = MCC_SOFTWARE
        )
        val cashbackSum = observable.calculateCashback(transactionInfo)
        Assertions.assertEquals(0.0, cashbackSum)
    }

}
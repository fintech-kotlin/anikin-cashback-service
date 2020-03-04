package ru.tinkoff.fintech.service.cashback.program

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ru.tinkoff.fintech.model.TransactionInfo
import ru.tinkoff.fintech.service.cashback.LOYALTY_PROGRAM_BEER
import ru.tinkoff.fintech.service.cashback.MCC_BEER
import java.time.LocalDate
import java.time.Month

class BeerProgramTest {

    private val observable = BeerProgram()

    @Test
    fun `BEER cashback for name = Олег with any case`() {
        val transactionInfo = TransactionInfo(
            loyaltyProgramName = LOYALTY_PROGRAM_BEER,
            transactionSum = 5000.0,
            cashbackTotalValue = 2500.0,
            firstName = "ОлЕг",
            lastName = "Кразаева",
            mccCode = MCC_BEER
        )
        val cashbackSum = observable.calculateCashback(transactionInfo)
        Assertions.assertEquals(350.0, cashbackSum)
    }

    @Test
    fun `BEER cashback for name = Олег and lastName = Олегов with any case`() {
        val transactionInfo = TransactionInfo(
            loyaltyProgramName = LOYALTY_PROGRAM_BEER,
            transactionSum = 5000.0,
            cashbackTotalValue = 2500.0,
            firstName = "ОлеГ",
            lastName = "ОлЕгОВ",
            mccCode = MCC_BEER
        )
        val cashbackSum = observable.calculateCashback(transactionInfo)
        Assertions.assertEquals(500.0, cashbackSum)
    }

    @Test
    fun `BEER cashback for firstName first letter equals month first letter`() {
        val transactionInfo = TransactionInfo(
            loyaltyProgramName = LOYALTY_PROGRAM_BEER,
            transactionSum = 5000.0,
            cashbackTotalValue = 2500.0,
            firstName = monthWithFirstLetter[LocalDate.now().month.value].toString(),
            lastName = "ОЛЕГОВ",
            mccCode = MCC_BEER
        )
        val cashbackSum = observable.calculateCashback(transactionInfo)
        Assertions.assertEquals(250.0, cashbackSum)
    }

    @Test
    fun `BEER cashback for firstName first letter equals previous month first letter`() {
        val transactionInfo = TransactionInfo(
            loyaltyProgramName = LOYALTY_PROGRAM_BEER,
            transactionSum = 5000.0,
            cashbackTotalValue = 2500.0,
            firstName = monthWithFirstLetter[LocalDate.now().minusMonths(1).month.value].toString(),
            lastName = "ОЛЕГОВ",
            mccCode = MCC_BEER
        )
        val cashbackSum = observable.calculateCashback(transactionInfo)
        Assertions.assertEquals(150.0, cashbackSum)
    }

    @Test
    fun `BEER cashback for firstName first letter equals next month first letter`() {
        val transactionInfo = TransactionInfo(
            loyaltyProgramName = LOYALTY_PROGRAM_BEER,
            transactionSum = 5000.0,
            cashbackTotalValue = 2500.0,
            firstName = monthWithFirstLetter[LocalDate.now().plusMonths(1).month.value].toString(),
            lastName = "ОЛЕГОВ",
            mccCode = MCC_BEER
        )
        val cashbackSum = observable.calculateCashback(transactionInfo)
        Assertions.assertEquals(150.0, cashbackSum)
    }

    val monthWithFirstLetter = mapOf(
        Month.JANUARY.value to 'я',
        Month.FEBRUARY.value to 'ф',
        Month.MARCH.value to 'м',
        Month.APRIL.value to 'а',
        Month.MAY.value to 'м',
        Month.JUNE.value to 'и',
        Month.JULY.value to 'и',
        Month.AUGUST.value to 'а',
        Month.SEPTEMBER.value to 'с',
        Month.OCTOBER.value to 'о',
        Month.NOVEMBER.value to 'н',
        Month.DECEMBER.value to 'д'
    )

}
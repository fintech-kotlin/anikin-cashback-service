package ru.tinkoff.fintech.utils

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class MoneyUtilsTest {

    @Test
    fun `round zero value`() {
        Assertions.assertEquals(0.0, roundSum(0.0))
    }

    @Test
    fun `round two digits`() {
        Assertions.assertEquals(1.11, roundSum(1.11))
    }

    @Test
    fun `round three digits 1`() {
        Assertions.assertEquals(1.12, roundSum(1.119))
    }

    @Test
    fun `round three digits 2`() {
        Assertions.assertEquals(1.11, roundSum(1.111))
    }

    @Test
    fun `round three digits 3`() {
        Assertions.assertEquals(1.12, roundSum(1.115))
    }

    @Test
    fun `round many digits`() {
        Assertions.assertEquals(1.12, roundSum(1.117392745178))
    }

}
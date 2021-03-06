package ru.tinkoff.fintech.utils

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class MoneyUtilsTest {

    @Test
    fun `round zero value`() {
        Assertions.assertEquals(0.0, 0.0.roundSum())
    }

    @Test
    fun `round two digits`() {
        Assertions.assertEquals(1.11, 1.11.roundSum())
    }

    @Test
    fun `round three digits 1`() {
        Assertions.assertEquals(1.12, 1.119.roundSum())
    }

    @Test
    fun `round three digits 2`() {
        Assertions.assertEquals(1.11, 1.111.roundSum())
    }

    @Test
    fun `round three digits 3`() {
        Assertions.assertEquals(1.12, 1.115.roundSum())
    }

    @Test
    fun `round many digits`() {
        Assertions.assertEquals(1.12, 1.117392745178.roundSum())
    }

}
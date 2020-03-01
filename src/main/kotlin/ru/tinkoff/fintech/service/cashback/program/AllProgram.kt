package ru.tinkoff.fintech.service.cashback.program

import ru.tinkoff.fintech.model.TransactionInfo
import ru.tinkoff.fintech.service.cashback.MCC_SOFTWARE
import ru.tinkoff.fintech.utils.roundSum
import java.math.BigDecimal

internal const val LCM_DIVIDER = 1000

class AllProgram : Program {
    override fun calculateCashback(transactionInfo: TransactionInfo): Double =
        roundSum(
            if (transactionInfo.mccCode == MCC_SOFTWARE && testPalindrome(transactionInfo.transactionSum * 100)) {
                lcm(
                    transactionInfo.firstName.length,
                    transactionInfo.lastName.length
                ).toDouble() / LCM_DIVIDER / 100 * transactionInfo.transactionSum
            } else 0.0
        )

    private fun testPalindrome(num: Double, substituteCount: Int = 1): Boolean {
        val numStrVal = BigDecimal(num).toPlainString()
        var testRange = 0

        for (i in 0..numStrVal.length / 2) {
            if (numStrVal[i] == numStrVal[numStrVal.length - i - 1])
                continue
            if (testRange++ == substituteCount)
                return false
        }

        return true
    }

    private fun gcd(a: Int, b: Int): Int {
        if (b == 0) return a
        return gcd(b, a % b)
    }

    private fun lcm(a: Int, b: Int): Int {
        return a / gcd(a, b) * b
    }
}
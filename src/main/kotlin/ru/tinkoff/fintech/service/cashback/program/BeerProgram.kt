package ru.tinkoff.fintech.service.cashback.program

import ru.tinkoff.fintech.model.TransactionInfo
import ru.tinkoff.fintech.service.cashback.MCC_BEER
import ru.tinkoff.fintech.utils.roundSum
import java.time.LocalDate
import java.time.Month
import java.time.format.TextStyle
import java.util.*

internal const val FIRST_NAME = "Олег"
internal const val FIRST_NAME_PERCENT = 10

internal const val SECOND_NAME = "Олегов"
internal const val SECOND_NAME_PERCENT = 7

internal const val CURRENT_MONTH_PERCENT = 5
internal const val NEAR_MONTH_PERCENT = 3
internal const val DEFAULT_PERCENT = 2


class BeerProgram : Program {
    override fun calculateCashback(transactionInfo: TransactionInfo): Double = roundSum(
        if (transactionInfo.mccCode == MCC_BEER) {
            if (FIRST_NAME.equals(transactionInfo.firstName, ignoreCase = true)) {
                if (SECOND_NAME.equals(transactionInfo.lastName, ignoreCase = true)) {
                    transactionInfo.transactionSum / 100 * FIRST_NAME_PERCENT
                } else {
                    transactionInfo.transactionSum / 100 * SECOND_NAME_PERCENT
                }
            } else if (getFirstLetterOfMonth().equals(transactionInfo.firstName[0], ignoreCase = true)) {
                transactionInfo.transactionSum / 100 * CURRENT_MONTH_PERCENT
            } else if (getFirstLetterOfMonth(-1).equals(transactionInfo.firstName[0], ignoreCase = true) ||
                getFirstLetterOfMonth(1).equals(transactionInfo.firstName[0], ignoreCase = true)
            ) {
                transactionInfo.transactionSum / 100 * NEAR_MONTH_PERCENT
            } else {
                transactionInfo.transactionSum / 100 * DEFAULT_PERCENT
            }
        } else 0.0
    )

    private fun getFirstLetterOfMonth(fromCurrent: Int = 0): Char =
        Month
            .of(LocalDate.now().month.value - fromCurrent)
            .getDisplayName(
                TextStyle.NARROW,
                Locale("ru", "rus")
            )[0]

}
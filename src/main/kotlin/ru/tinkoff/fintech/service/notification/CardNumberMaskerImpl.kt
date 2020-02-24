package ru.tinkoff.fintech.service.notification

class CardNumberMaskerImpl : CardNumberMasker {

    override fun mask(cardNumber: String, maskChar: Char, start: Int, end: Int): String {
        val lastIndex = getLastIndex(end, cardNumber.length)
        return cardNumber.replaceRange(start, lastIndex, maskChar.toString().repeat(lastIndex - start))
    }

    private fun getLastIndex(end: Int, length: Int): Int = if (end > length) length else end
}
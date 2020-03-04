package ru.tinkoff.fintech.utils

import kotlin.math.round

fun Double.roundSum() = round(this * 100) / 100

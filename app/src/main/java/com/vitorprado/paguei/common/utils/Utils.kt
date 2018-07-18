package com.vitorprado.paguei.common.utils

import java.text.SimpleDateFormat
import java.util.*

class Utils {
    companion object {
        fun getLocalDateFormated(date: Date): String {
            val locale = Locale.getDefault()
            lateinit var defaultLocal : SimpleDateFormat
            if (locale == Locale.US)
                defaultLocal = SimpleDateFormat("yyyy/MM/dd", locale)
            else
                defaultLocal = SimpleDateFormat("dd/MM/yyyy", locale)

            return defaultLocal.format(date)
        }
    }
}
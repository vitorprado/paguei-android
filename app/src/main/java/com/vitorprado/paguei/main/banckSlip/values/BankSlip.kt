package com.vitorprado.paguei.main.banckSlip.values

import java.util.*

data class BankSlip(
        val name: String,
        val value: Double,
        val date: Date,
        val barcode: String
)
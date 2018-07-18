package com.vitorprado.paguei.main.banckSlip

interface BankSlipContract {

    interface View{
        fun scan()
    }

    interface Presenter{
        fun getDados(barcode : String)
    }
}
package com.vitorprado.paguei.main.banckSlip

import com.vitorprado.paguei.common.BasePresenter
import com.vitorprado.paguei.common.decorator.DecoratedContract
import com.vitorprado.paguei.common.utils.Utils
import com.vitorprado.paguei.main.banckSlip.values.BankSlip
import java.util.*

class BankSlipPresenter(contract: DecoratedContract<BankSlip>, val view : BankSlipContract.View) :
        BasePresenter<BankSlip>(contract), BankSlipContract.Presenter {

    var name: String = ""
        set(value) {
            field = value
            notifyChange()
        }

    var value: String = ""
        set(value) {
            field = value
            notifyChange()
        }

    var date: String = ""
        set(value) {
            field = value
            notifyChange()
        }

    var barcode: String = ""
        set(value) {
            field = value
            notifyChange()
        }

    fun scanClick() {
        //startLoading()
        view.scan()
    }

    override fun getDados(barcode : String) {
        if (barcode.isEmpty())
            return

        name = "CPFL"
        value = "R$100,00"
        date = Utils.getLocalDateFormated(Calendar.getInstance().time)
        this.barcode = barcode
    }
}
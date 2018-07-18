package com.vitorprado.paguei.main.banckSlip

import android.support.design.widget.Snackbar
import com.vitorprado.paguei.common.decorator.Decorator
import com.vitorprado.paguei.databinding.BankSlipBinding

class BankSlipDecorator(private val databind: BankSlipBinding) : Decorator(databind) {
    override fun decorateLoading() {
        //
    }

    override fun decorateError() {
        Snackbar.make(databind.root, "Error, try again", Snackbar.LENGTH_SHORT).show()
    }

    override fun decorateSuccess(doneCallback: () -> Any?) {
        //
    }
}
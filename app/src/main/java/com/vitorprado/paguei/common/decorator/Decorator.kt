package com.vitorprado.paguei.common.decorator

import android.databinding.ViewDataBinding

abstract class Decorator(val databinding: ViewDataBinding) {
    abstract fun decorateLoading()
    abstract fun decorateError()
    abstract fun decorateSuccess(doneCallback: () -> Any?)
}
package com.vitorprado.paguei.common.decorator

import com.vitorprado.paguei.common.BaseContract

abstract class DecoratedContract<T>(private val decorator: Decorator) : BaseContract<T> {

    abstract fun onDone(data: T?)

    override fun onLoading() {
        decorator.decorateLoading()
    }

    override fun onError(message: String?) {
        decorator.decorateError()
    }

    override fun onSuccess(data: T?) {
        decorator.decorateSuccess({ onDone(data) })
    }
}
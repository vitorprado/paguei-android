package com.vitorprado.paguei.common

import android.databinding.BaseObservable

open class BasePresenter<T>(private val contract: BaseContract<T>) : BaseObservable() {

    var isLoading = false
        private set

    fun startLoading() {
        isLoading = true
        contract.onLoading()
        notifyChange()
    }

    fun showSuccess(data: T?) {
        isLoading = false
        contract.onSuccess(data)
        notifyChange()
    }

    fun showError(message: String?) {
        isLoading = false
        contract.onError(message)
        notifyChange()
    }
}
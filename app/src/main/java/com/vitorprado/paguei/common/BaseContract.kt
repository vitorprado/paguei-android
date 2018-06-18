package com.vitorprado.paguei.common

interface BaseContract<T> {
    fun onLoading()
    fun onError(message: String? = null)
    fun onSuccess(data: T?)
}
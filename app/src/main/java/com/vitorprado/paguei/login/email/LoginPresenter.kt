package com.vitorprado.paguei.login.email

import com.vitorprado.paguei.common.BasePresenter
import com.vitorprado.paguei.common.decorator.DecoratedContract
import com.vitorprado.paguei.login.email.values.Credentials
import com.vitorprado.paguei.login.email.values.User
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LoginPresenter(contract: DecoratedContract<User>, private val submitFunction: (Credentials) -> Observable<User>) : BasePresenter<User>(contract) {

    var username: String = ""
        set(value) {
            field = value
            notifyChange()
        }
    var password: String = ""
        set(value) {
            field = value
            notifyChange()
        }

    val loginIsValid: Boolean
        get() = username.isNotEmpty() && password.isNotEmpty()

    fun loginClick() {
        startLoading()
        submitFunction(Credentials(username, password))
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { user ->
                            showSuccess(user)
                        },
                        { error ->
                            showError("Error")
                        }
                )
    }
}
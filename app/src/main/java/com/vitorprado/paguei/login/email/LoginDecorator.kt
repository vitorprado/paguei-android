package com.vitorprado.paguei.login.email

import android.support.design.widget.Snackbar
import com.vitorprado.paguei.extensions.circularReveal
import com.vitorprado.paguei.common.decorator.Decorator
import com.vitorprado.paguei.databinding.LoginBinding

class LoginDecorator(private val databind: LoginBinding) : Decorator(databind) {
    override fun decorateLoading() {}

    override fun decorateError() {
        Snackbar.make(databind.root, "Error loading user, try again", Snackbar.LENGTH_SHORT).show()
    }

    override fun decorateSuccess(doneCallback: () -> Any?) {
        databind.reveal.circularReveal(databind.loginButton, doneCallback)
    }
}
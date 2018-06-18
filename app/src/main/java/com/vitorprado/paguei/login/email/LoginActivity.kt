package com.vitorprado.paguei.login.email

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.vitorprado.paguei.R
import com.vitorprado.paguei.common.decorator.DecoratedContract
import com.vitorprado.paguei.databinding.LoginBinding
import com.vitorprado.paguei.login.email.values.Credentials
import com.vitorprado.paguei.login.email.values.User
import io.reactivex.Observable

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dataBind = DataBindingUtil.setContentView<LoginBinding>(this, R.layout.login)
        dataBind.presenter = LoginPresenter(contract(dataBind), loginRequest)
//        disableBackSharedElementAnimation(dataBind.logo)
    }

    private fun contract(binding: LoginBinding) = object : DecoratedContract<User>(LoginDecorator(binding)) {
        override fun onDone(data: User?) {
            finish()
        }
    }

    private val loginRequest = { credential: Credentials ->
        Observable.create<User> { emitter ->
            Thread.sleep(5 * 1000)
            emitter.onNext(User(""))
            emitter.onComplete()
        }
//        Repository.get().forLogin().login(credential)
    }


}

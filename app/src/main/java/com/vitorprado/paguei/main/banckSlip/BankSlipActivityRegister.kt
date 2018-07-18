package com.vitorprado.paguei.main.banckSlip

import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.zxing.integration.android.IntentIntegrator
import com.vitorprado.paguei.R
import com.vitorprado.paguei.common.decorator.DecoratedContract
import com.vitorprado.paguei.databinding.BankSlipBinding
import com.vitorprado.paguei.main.banckSlip.values.BankSlip

class BankSlipActivityRegister : AppCompatActivity(), BankSlipContract.View {

    private lateinit var dataBind : BankSlipBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBind = DataBindingUtil.setContentView(this, R.layout.bank_slip)
        dataBind.presenter = BankSlipPresenter(contract(dataBind), this)

        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.title = "Nova conta"
        }

        scan()
    }

    private fun contract(binding: BankSlipBinding) = object : DecoratedContract<BankSlip>(BankSlipDecorator(binding)) {
        override fun onDone(data: BankSlip?) {
            finish()
        }
    }

    override fun scan() {
        IntentIntegrator(this).initiateScan()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            if (result.contents == null) {
            } else {
                dataBind.presenter!!.getDados(result.contents)
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                setResult(1)
                finish()
            }
            R.id.action_save -> {
                //
            }
            else -> {
                //
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.save, menu)
        return true
    }
}
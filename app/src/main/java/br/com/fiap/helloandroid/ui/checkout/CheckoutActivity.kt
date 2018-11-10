package br.com.fiap.helloandroid.ui.checkout

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.fiap.helloandroid.R
import br.com.fiap.helloandroid.model.Pedido

class CheckoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        val pedido = intent.getParcelableExtra<Pedido>("pedido")
        Toast.makeText(this,pedido.nome, Toast.LENGTH_LONG).show()
    }
}

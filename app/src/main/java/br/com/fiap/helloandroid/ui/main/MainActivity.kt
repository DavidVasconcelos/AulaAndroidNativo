package br.com.fiap.helloandroid.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.fiap.helloandroid.R
import br.com.fiap.helloandroid.model.Pedido
import br.com.fiap.helloandroid.ui.checkout.CheckoutActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProviders
                .of(this)
                .get(MainViewModel::class.java)

        mainViewModel.nomeCliente = intent.getStringExtra("nome")
        mainViewModel.telefoneCliente = intent.getStringExtra("telefone")

        tvNome.text = getString(R.string.saudacao,  mainViewModel.nomeCliente,  mainViewModel.telefoneCliente)

        cbAtum.setOnCheckedChangeListener { buttonView, isChecked ->
            mainViewModel.atumSelecionado = isChecked
        }

        cbBacon.setOnCheckedChangeListener { buttonView, isChecked ->
            mainViewModel.baconSelecionado = isChecked
        }

        cbCalabresa.setOnCheckedChangeListener { buttonView, isChecked ->
            mainViewModel.calabresaSelecionada = isChecked
        }

        cbMussarela.setOnCheckedChangeListener { buttonView, isChecked ->
            mainViewModel.mussarelaSelecionada = isChecked
        }

        cbAtum.isChecked = mainViewModel.atumSelecionado
        cbBacon.isChecked = mainViewModel.baconSelecionado
        cbCalabresa.isChecked = mainViewModel.calabresaSelecionada
        cbMussarela.isChecked = mainViewModel.mussarelaSelecionada

        btCalcular.setOnClickListener {
            val intent = Intent(this, CheckoutActivity::class.java)
            intent.putExtra("pedido", gerarPedido())
            startActivity(intent)
        }
    }

    private fun gerarPedido(): Pedido {
        return Pedido(mainViewModel.nomeCliente, mainViewModel.telefoneCliente)
    }
}

package br.com.fiap.helloandroid.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.CompoundButton
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

        tvNome.text = getString(R.string.saudacao, mainViewModel.nomeCliente, mainViewModel.telefoneCliente)

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

        rbPequena.setOnCheckedChangeListener { compoundButton: CompoundButton?, b: Boolean ->
            mainViewModel.rbPequena = b
        }

        rbMedia.setOnCheckedChangeListener { compoundButton, b ->
            mainViewModel.rbMedia = b
        }

        rbGrande.setOnCheckedChangeListener { compoundButton, b ->
            mainViewModel.rbGrande = b
        }

        spFormaPagamento.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                mainViewModel.formaPagamento = p2
            }

        }

        cbAtum.isChecked = mainViewModel.atumSelecionado
        cbBacon.isChecked = mainViewModel.baconSelecionado
        cbCalabresa.isChecked = mainViewModel.calabresaSelecionada
        cbMussarela.isChecked = mainViewModel.mussarelaSelecionada

        rbPequena.isChecked = mainViewModel.rbPequena
        rbMedia.isChecked = mainViewModel.rbMedia
        rbGrande.isChecked = mainViewModel.rbGrande

        spFormaPagamento.getItemAtPosition(mainViewModel.formaPagamento)


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

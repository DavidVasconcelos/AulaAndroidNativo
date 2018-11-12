package br.com.fiap.helloandroid.ui.main

import android.arch.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var nomeCliente = ""
    var telefoneCliente = ""

    var atumSelecionado = false
    var baconSelecionado = false
    var calabresaSelecionada = false
    var mussarelaSelecionada = false

    var rbPequena = false
    var rbMedia = false
    var rbGrande = false

    var formaPagamento = 0

}
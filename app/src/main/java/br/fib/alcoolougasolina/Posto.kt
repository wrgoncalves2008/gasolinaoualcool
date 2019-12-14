package br.fib.alcoolougasolina

import java.io.Serializable

data class Posto (

    var nome: String,
    var precoAlcool: Double,
    var precoGasolina: Double

    ) :  Serializable {

    override fun toString() : String{
        return this.nome
    }

}
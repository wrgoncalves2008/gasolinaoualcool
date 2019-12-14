package br.fib.alcoolougasolina

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.strictmode.WebViewMethodCalledOnWrongThreadViolation
import android.util.Log
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var lstpostos = findViewById<View>(R.id.lstpostos) as ListView
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1, postos)
        lstpostos.adapter = adapter

        var edtGasolina = findViewById<View>(R.id.editGasolina) as EditText
        var edtAlcool = findViewById<View>(R.id.editAlcool) as EditText
        var btnCalcular = findViewById<View>(R.id.buttonCalcular) as Button

        var nomePostoSelecionado = ""

        lstpostos.setOnItemClickListener { parent, view, position, id ->
            edtGasolina.setText( postos[position].precoGasolina.toString() )
            edtAlcool.setText( postos[position].precoAlcool.toString() )
            nomePostoSelecionado = postos[position].nome
        }


        btnCalcular.setOnClickListener{

            var vValorGasolina = edtGasolina.getText().toString().toDoubleOrNull()

            var vValorAlcool = edtAlcool.getText().toString().toDoubleOrNull()


            if (vValorAlcool == null)
            {
                Toast.makeText(this@MainActivity, "Valor informado do Álcool é inválido!", Toast.LENGTH_LONG).show()
            }


            if (vValorGasolina == null)
            {
                Toast.makeText(this@MainActivity, "Valor informado da Gasolina é inválido!", Toast.LENGTH_LONG).show()
            }

            val intent = Intent(this@MainActivity, ResultadoActivity::class.java)

            intent.putExtra("posto", nomePostoSelecionado)

            if ((vValorGasolina != null) && (vValorAlcool != null)) {

                var vResultado = (vValorAlcool / vValorGasolina)

                if (vResultado < 0.7) {
                    intent.putExtra("resultado", "Álcool")
                } else {
                    intent.putExtra("resultado", "Gasolina")
                }
            }

            startActivity(intent)
        }
    }

    companion object{
        internal val postos = arrayOf(Posto( "Posto Ipiranga", 2.31,3.33 ),
                                      Posto( "Posto BR", 2.68,3.49 ),
                                      Posto( "Posto Shell", 2.15,4.58 ),
                                      Posto( "Posto Texaco", 3.12,4.78 ),
                                      Posto( "Posto do Zé", 2.49,4.39 ))
    }
}

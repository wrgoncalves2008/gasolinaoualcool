package br.fib.alcoolougasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var edtGasolina = findViewById<View>(R.id.editGasolina) as EditText
        var edtAlcool = findViewById<View>(R.id.editAlcool) as EditText
        var btnCalcular = findViewById<View>(R.id.buttonCalcular) as Button
        var txtResultado = findViewById<View>(R.id.txtResultado) as TextView

        btnCalcular.setOnClickListener{

            txtResultado.setText("")

            Log.i("aula" , "Valor informado da Gasolina: " + edtGasolina.text.toString())
            var vValorGasolina = edtGasolina.getText().toString().toDoubleOrNull()

            Log.i("aula" , "Valor informado do Álcool: " + edtAlcool.text.toString())
            var vValorAlcool = edtAlcool.getText().toString().toDoubleOrNull()


            if (vValorAlcool == null)
            {
                Log.i("aula", "Valor informado do Álcool é inválido!")
                Toast.makeText(this@MainActivity, "Valor informado do Álcool é inválido!", Toast.LENGTH_LONG).show()
            }


            if (vValorGasolina == null)
            {
                Log.i("aula", "Valor informado da Gasolina é inválido!")
                Toast.makeText(this@MainActivity, "Valor informado da Gasolina é inválido!", Toast.LENGTH_LONG).show()
            }

            if ((vValorGasolina != null) && (vValorAlcool != null)) {

                var vResultado = (vValorAlcool / vValorGasolina)
                Log.i("aula", "Resultado do calculo: " + vResultado.toString())


                if (vResultado < 0.7) {
                    Log.i("aula", "Utilize Álcool!")
                    txtResultado.setText("Utilize Álcool!")
                } else {
                    Log.i("aula", "Utilize Gasolina!")
                    txtResultado.setText("Utilize Gasolina!")
                }
            }

        }
    }
}

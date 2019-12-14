package br.fib.alcoolougasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class ResultadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        var opcao = intent.getStringExtra("resultado")
        var nomeposto = intent.getStringExtra("posto")


        var tv = findViewById<View>(R.id.tvResultado) as TextView
        var tvnomeposto = findViewById<View>(R.id.tvnomposto) as TextView

        tvnomeposto.setText("A melhor no $nomeposto é:")
        tv.setText(opcao)
    }
}

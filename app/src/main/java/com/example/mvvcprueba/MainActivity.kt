package com.example.mvvcprueba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
//para no usar findViewById
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Instanciamos el ViewModel
        // nomenclatura que necesita utilizar jvm 1.8
        // se configure en project structure -> Modules -> Target Compatibillity
        val miModelo by viewModels<MyViewModel>()
        //miModelo.ronda.value
        val texto = findViewById<TextView>(R.id.textRonda)
        //texto.text = miModelo.ronda.value.toString()
        miModelo.ronda.observe(this, Observer{
            nuevaRonda -> textRonda.text = nuevaRonda.toString()
        })
        sumarRonda.setOnClickListener(){
            miModelo.sumarRonda()
        }

    }
}
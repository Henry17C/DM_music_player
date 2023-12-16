package com.coyago.musicplayer.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.coyago.musicplayer.R

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        temporizador()
    }



    fun temporizador(){
        val intent= Intent(this, StartActivity::class.java)
        val timer = object : CountDownTimer(2000, 1000) {
            // El primer parámetro es el tiempo total del temporizador en milisegundos (en este caso, 2000 ms o 2 segundos)
            // El segundo parámetro es el intervalo entre las actualizaciones del temporizador (en este caso, 1000 ms o 1 segundo)

            override fun onTick(millisUntilFinished: Long) {
                // Se llama en cada intervalo del temporizador (cada segundo en este caso)
                // Puedes realizar acciones aquí si necesitas realizar alguna tarea recurrente
            }

            override fun onFinish() {
                // Se llama cuando el temporizador alcanza su límite de tiempo (en este caso, después de 2 segundos)
                // Puedes realizar acciones aquí cuando el temporizador finaliza

                startActivity(intent)

            }


        }
        timer.start()
    }
}
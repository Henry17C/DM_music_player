package com.coyago.musicplayer.ui.activities

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.coyago.musicplayer.R
import com.coyago.musicplayer.logic.MusicUtils

class FirstActivity : AppCompatActivity() {

   private val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                // Permission is granted. Continue the action or workflow in your
                // app.
            } else {
                // Explain to the user that the feature is unavailable because the
                // feature requires a permission that the user has denied. At the
                // same time, respect the user's decision. Don't link to system
                // settings in an effort to convince the user to change their
                // decision.
            }
        }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)


        requestPermissionLauncher.launch(Manifest.permission.READ_MEDIA_AUDIO)
/*
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
            != PackageManager.PERMISSION_GRANTED
        ) {

            Log.d("Permiso", "SOLICITA PERMISO")
            // Solicitar permisos
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.READ_MEDIA_AUDIO),
                1
            )
        } else {
            // Si ya se han otorgado los permisos, realizar la operación que necesita permisos
            // cargarListaDeCanciones()

            Log.d("Permiso", "NO SOLICITA PERMISO")
        }

*/









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
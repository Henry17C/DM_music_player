package com.coyago.musicplayer.ui.activities

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.coyago.musicplayer.databinding.ActivityStartBinding
import com.coyago.musicplayer.logic.MusicUtils

class StartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStartBinding

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        // Este método se llama cuando el usuario responde a la solicitud de permisos.
        // Verifica si se otorgaron los permisos y actúa en consecuencia.
        if (requestCode == 1) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // El usuario otorgó el permiso, puedes proceder con la reproducción de música.
                // cargarListaDeCanciones()
            } else {
                // El usuario denegó el permiso. Puedes informar al usuario sobre la importancia del permiso.
                // También podrías proporcionar una opción para que el usuario lo configure manualmente en la configuración de la aplicación.
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initControls()





    }

     fun initControls(){

         binding.btnIniciarSesion.setOnClickListener {
             val intent= Intent(this, SignInActivity::class.java)
             startActivity(intent)
         }

         binding.btnRegistrate.setOnClickListener {
             val intent1= Intent(this, SignUpActivity::class.java)
             startActivity(intent1)

         }


         binding.btnInvitado.setOnClickListener {
             val intent1= Intent(this, PrincipalActivity::class.java)
             startActivity(intent1)

         }
     }

  fun  cargarListaDeCanciones(){

      val musicUtils= MusicUtils(this)
      println("HOLAAAAAA")
      var listMusic= musicUtils.getAllSongs()
      if(listMusic.isEmpty()){
          println("ESTA VACIO!!!!!!")
      }else{
          println("SI TIENE ELEMENTOS")
      }

      for ( song in listMusic ){
          println("INGRESA")

          println("NOMBRE: $song.title, URI:${song.contentUri}")
          println("SALE")

      }
      println("CHAOOOOOO!!!!")
      println("LOGITUD DE LA LISTA DE CANCIONES:  ${listMusic.size}")


  }








}
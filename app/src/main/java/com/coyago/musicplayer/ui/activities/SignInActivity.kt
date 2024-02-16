package com.coyago.musicplayer.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.coyago.musicplayer.data.core.My_Applycation
import com.coyago.musicplayer.databinding.ActivitySignInBinding
import com.coyago.musicplayer.logic.local.login.LoginUserCase
import com.google.android.material.snackbar.Snackbar

class SignInActivity : AppCompatActivity() {

    lateinit var  binding: ActivitySignInBinding
    //private val login: LoginUserCase= LoginUserCase(My_Applycation.getConnectionDB())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }


    override fun onStart() {
        super.onStart()
        initControls()

    }
    override fun onDestroy() {
        super.onDestroy()
    }

    fun initControls(){
           //boton Atras
        binding.btnArrow.setOnClickListener {
                val intent1= Intent(this, StartActivity::class.java)
                startActivity(intent1)
        }

            //inicio de sesion
        binding.buttonSesion.setOnClickListener {

            var email= binding.etEmail.text.toString()
            var password= binding.etPassword.text.toString()
            var check= LoginUserCase(My_Applycation.getConnectionDB())?.checkLoginReturn(email,password)

            if(check ?: 0 > 0){
                val intent2= Intent(this, PrincipalActivity::class.java)
                startActivity(intent2)
            }else{
                Snackbar.make(binding.buttonSesion,"Usuario o" +
                        "contraseña incorrecta", Snackbar.LENGTH_LONG).show()
            }
        }


    }





}
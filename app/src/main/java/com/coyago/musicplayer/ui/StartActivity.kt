package com.coyago.musicplayer.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.coyago.musicplayer.R
import com.coyago.musicplayer.databinding.ActivityStartBinding

class StartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStartBinding




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
     }










}
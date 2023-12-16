package com.coyago.musicplayer.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.coyago.musicplayer.R
import com.coyago.musicplayer.databinding.ActivitySignInBinding
import com.coyago.musicplayer.databinding.ActivitySignUpBinding

class SignInActivity : AppCompatActivity() {

    lateinit var  binding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initControls()
    }


    fun initControls(){

        binding.btnArrow.setOnClickListener {

            intent= Intent(this, StartActivity::class.java )
            startActivity(intent)
        }


    }

}
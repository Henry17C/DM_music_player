package com.coyago.musicplayer.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.coyago.musicplayer.R
import com.coyago.musicplayer.databinding.ActivitySignUpBinding
import com.coyago.musicplayer.databinding.ActivityStartBinding

class SignUpActivity : AppCompatActivity() {

    lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initControls()
    }




    fun initControls(){
        binding.btnArrow.setOnClickListener {
            val intent= Intent(this, StartActivity::class.java)
            startActivity(intent)

        }


    }


}
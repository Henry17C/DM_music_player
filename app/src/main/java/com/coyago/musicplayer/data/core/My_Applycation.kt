package com.coyago.musicplayer.data.core

import android.app.Application
import com.coyago.musicplayer.data.local.repository.DBConnection
import com.coyago.musicplayer.data.local.repository.DBRepository
import com.coyago.musicplayer.logic.local.login.LoginUserCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

// Clase donde voy a tener el control de la aplicación, en general, no solo de un activity
class My_Applycation:Application() {


    override fun onCreate() {
        super.onCreate()
        con = DBConnection().getConnection(applicationContext)

        GlobalScope.launch(Dispatchers.IO){

            LoginUserCase(con).insertUsers()

        }


    }

    //objeto que pertenece a la clase
   companion object{
        private lateinit var con: DBRepository

        fun getConnectionDB(): DBRepository {
           return con
                    }
   }

}
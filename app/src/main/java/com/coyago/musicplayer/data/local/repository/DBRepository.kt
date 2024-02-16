package com.coyago.musicplayer.data.local.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.coyago.musicplayer.data.local.dato.UsersDAO
import com.coyago.musicplayer.data.local.entities.Users

@Database(
    entities = [Users::class],
    version = 3
)

abstract class DBRepository: RoomDatabase() {

    abstract fun getUserDAO(): UsersDAO;

}

class DBConnection(){

    fun getConnection(context: Context): DBRepository=
        Room.databaseBuilder(context,DBRepository::class.java, "DBText").build()

}
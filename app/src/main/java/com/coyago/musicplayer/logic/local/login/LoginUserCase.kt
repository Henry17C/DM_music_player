package com.coyago.musicplayer.logic.local.login

import android.content.Context
import android.util.Log
import com.coyago.musicplayer.data.local.entities.Users
import com.coyago.musicplayer.data.local.repository.DBRepository
import com.coyago.musicplayer.data.local.repository.UsersRepository

class LoginUserCase  (val connection: DBRepository){

    fun checkLoginReturn(email: String, password:String): Int{
        val users= UsersRepository().getListUsers()
        var ret=-1
        val lstUsers= users.filter { it.email==email && it.password==password }

        if(lstUsers.isNotEmpty()){
            ret= lstUsers.first().id
        }

        Log.d("NOMBRE", ret.toString())
        return ret;
    }

    suspend fun insertUsers(){

        if(connection.getUserDAO().getAllUsers().isEmpty()){
            connection.getUserDAO().insertUser(UsersRepository().getListUsers())
        }else{

        }

    }

    suspend fun insertSingleUser(user: Users){
        connection.getUserDAO().insertSingleUser(user)

    }

    suspend fun getUserNameDB(id:Int, context: Context): Users {

        return   connection.getUserDAO().getSingleUser(id)

    }




}
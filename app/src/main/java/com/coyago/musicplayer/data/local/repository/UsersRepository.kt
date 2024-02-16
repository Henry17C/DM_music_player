package com.coyago.musicplayer.data.local.repository

import com.coyago.musicplayer.data.local.entities.Users

class UsersRepository {

    fun getListUsers():List<Users>{
        var lstUsers= listOf(
          Users(1,"henry","12345","Henry","Coyago"),
            Users(2,"ibeth","12345","Ibeth","Coyago")
        )
        return lstUsers
    }

}
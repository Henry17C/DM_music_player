package com.coyago.musicplayer.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Users (var email: String?=null,
                  var password:String?=null )
                    {
                        @PrimaryKey(autoGenerate = true)
                        var id: Int=-1
                        var name: String= "No registrado"
                        var lastname:String= "No registrado"
                        constructor(id: Int, email: String?,password: String?,name: String,lastname:String): this(
                            email,
                            password
                            ){
                            this.id = id
                            this.name = name
                            this.lastname = lastname
                        }
                    }
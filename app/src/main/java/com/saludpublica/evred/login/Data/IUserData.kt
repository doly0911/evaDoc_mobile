package com.saludpublica.evred.login.Data

import com.saludpublica.evred.login.Model.UserModel

interface IUserData {
    fun getStundent(email:String):UserModel?
}
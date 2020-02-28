package com.saludpublica.evred.login.View

import com.saludpublica.evred.login.Model.UserModel


interface ILoginView {
    fun onLoginError(message: String)
    fun onLoginSuccess(message: String, user:UserModel)
}
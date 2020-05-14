package com.saludpublica.evred.login.Presenter

interface ILoginPresenter {
    fun onLogin(email: String, password: String)
    fun isDataValid(email: String):Int
    fun isUser(email: String, password: String)
}
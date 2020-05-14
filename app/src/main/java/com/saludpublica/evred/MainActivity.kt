package com.saludpublica.evred

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.saludpublica.evred.login.Model.UserModel
import com.saludpublica.evred.login.Presenter.ILoginPresenter
import com.saludpublica.evred.login.Presenter.LoginPresenter
import com.saludpublica.evred.login.View.ILoginView
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.fragment_home.*


class MainActivity : AppCompatActivity(), ILoginView {
    lateinit var editor: SharedPreferences.Editor

    override fun onLoginError(message: String) {
        Toasty.error(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onLoginSuccess(message: String, user: UserModel) {
        Toasty.success(this, message, Toast.LENGTH_SHORT).show()
        val intent = Intent(this, MisCursosActivity::class.java)

        editor.putString("email", user.email)
        editor.putString("name", user.name)
        editor.putString("cargo", user.cargo)
        editor.commit()
        startActivity(intent)
        finish()
    }

    internal lateinit var loginPresenter: ILoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //init
        loginPresenter = LoginPresenter(this)

        //event
        loginButton.setOnClickListener {
            loginPresenter.onLogin(emailEditText.text.toString(), passwordEditText.text.toString())
        }
        val pref = applicationContext.getSharedPreferences(
            "UserData",
            Context.MODE_PRIVATE
        )
        editor = pref.edit()
    }
}

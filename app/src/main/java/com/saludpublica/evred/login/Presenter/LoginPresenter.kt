package com.saludpublica.evred.login.Presenter

import android.text.TextUtils
import android.util.Patterns
import com.saludpublica.evred.login.Data.UserData
import com.saludpublica.evred.login.Model.UserModel
import com.saludpublica.evred.login.View.ILoginView

class LoginPresenter(internal var iLoginView: ILoginView) : ILoginPresenter {
    private val studentData: UserData = UserData()

    override fun isStudent(email: String, password: String) {
        //busca en la base de datos el email y se trae la informacion nesesario
        // email password nombre materias
        val user: UserModel? = studentData.getStundent(email)
        if (user != null) {
            if (password == user.password) {
                iLoginView.onLoginSuccess("Login success", user)
            } else {
                iLoginView.onLoginError("Incorrect password")
            }
        } else {
            iLoginView.onLoginError("Email doesn't exit")
        }
    }

    override fun isDataValid(email: String): Int {
        return when {
            TextUtils.isEmpty(email) -> 0 //0 error code is email empty
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> 1 //1 error code is not a email
            else -> -1 //-1 is success code
        }
    }


    override fun onLogin(email: String, password: String) {
        val isLoginCode = isDataValid(email)
        when (isLoginCode) {
            0 -> iLoginView.onLoginError("Please enter a valid email")
            1 -> iLoginView.onLoginError("Invalid email, check email")
            -1 -> isStudent(email, password)
        }
    }

}
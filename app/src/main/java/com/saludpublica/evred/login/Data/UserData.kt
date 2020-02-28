package com.saludpublica.evred.login.Data

import com.saludpublica.evred.login.Model.UserModel


class UserData: IUserData
{
    override fun getStundent(email: String): UserModel? {
        //if que verifica si el email existe en la base de datos, cambiar luego por la validacion correspondiente
        //con el consumo de apis
        if(email=="eduardo.velasquezv@udea.edu.co"){
            return UserModel("eduardo.velasquezv@udea.edu.co", "123456789", "eduardo velasquez","estudiante")
        }
        if(email=="docente@udea.edu.co"){
            return UserModel("docente@udea.edu.co","123456789","docente #1","docente")
        }
        if (email=="compromiso@udea.edu.co"){
            return UserModel("compromiso@udea.edu.co","123456789","compromiso#1","compromiso")
        }
        return null
    }

}
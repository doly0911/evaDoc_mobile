package com.saludpublica.evred.login.Data

import com.saludpublica.evred.login.Model.UserModel


class UserData: IUserData
{
    override fun getUser(email: String): UserModel? {
        //if que verifica si el email existe en la base de datos, cambiar luego por la validacion correspondiente
        //con el consumo de apis
        if(email=="estudiante@udea.edu.co"){
            return UserModel("estudiante@udea.edu.co", "123", "estudiante 1","estudiante")
        }
        if(email=="docente@udea.edu.co"){
            return UserModel("docente@udea.edu.co","123","docente #1","docente")
        }
        if (email=="compromiso@udea.edu.co"){
            return UserModel("compromiso@udea.edu.co","123","compromiso#1","compromiso")
        }
        return null
    }

}
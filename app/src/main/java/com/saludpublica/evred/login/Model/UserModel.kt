package com.saludpublica.evred.login.Model

class UserModel(
    override val email: String, override val password: String,
    override val name: String, override val cargo: String
) : IUserModel
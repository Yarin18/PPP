package com.yarin.loginformchallenge

import java.io.Serializable

class User(val title: String, val firstName: String, val lastName: String, val email: String, val phone: String, val passwordString: String) : Serializable {

    fun getFullName() = "$title $firstName $lastName"

}
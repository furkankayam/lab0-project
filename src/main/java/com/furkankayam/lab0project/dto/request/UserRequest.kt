package com.furkankayam.lab0project.dto.request

import jakarta.persistence.Column

data class UserRequest(
    var firstName: String,

    val lastName: String,

    val phoneNumber: String,

    val password: String? = null,

    val email: String? = null,

    val address: String
)

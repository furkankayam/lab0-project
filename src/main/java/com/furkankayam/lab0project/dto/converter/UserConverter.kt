package com.furkankayam.lab0project.dto.converter

import com.furkankayam.lab0project.dto.request.UserRequest
import com.furkankayam.lab0project.dto.response.UserResponse
import com.furkankayam.lab0project.model.User

fun User.toUserResponse(): UserResponse {
    return UserResponse(
        firstName = this.firstName,
        lastName = this.lastName,
        phoneNumber = this.phoneNumber,
        address = this.address
    )
}

fun UserRequest.toUser(): User {
    return User(
        firstName = this.firstName,
        lastName = this.lastName,
        phoneNumber = this.phoneNumber,
        password = this.password,
        address = this.address
    )
}
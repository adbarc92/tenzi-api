package com.barclay.tenziapi.models.dto

import com.barclay.tenziapi.models.database.User

data class UserDTO(
    val name: String,
    val email: String,
    val profilePictureUrl: String?,
)

fun User.toDTO(): UserDTO {
    return UserDTO(
        name = name,
        email = email,
        profilePictureUrl = profilePictureUrl,
    )
}
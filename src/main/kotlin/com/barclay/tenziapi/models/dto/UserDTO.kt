package com.barclay.tenziapi.models.dto

data class UserDTO(
    val name: String,
    val email: String,
    val profilePictureUrl: String?,
)
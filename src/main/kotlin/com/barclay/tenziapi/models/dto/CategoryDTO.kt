package com.barclay.tenziapi.models.dto

import com.barclay.tenziapi.models.database.Category

data class CategoryDTO(
    val id: String,
    val name: String,
    val creatorId: String,
)

fun Category.toDTO(): CategoryDTO {
    return CategoryDTO(
        id = id,
        name = name,
        creatorId = creator.firebaseId,
    )
}
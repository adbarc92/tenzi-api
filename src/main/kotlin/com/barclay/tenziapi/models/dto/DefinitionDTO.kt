package com.barclay.tenziapi.models.dto

import com.barclay.tenziapi.models.database.Definition

data class DefinitionDTO(
    val name: String,
    val category: CategoryDTO,
    val author: UserDTO,
)

fun Definition.toDTO(): DefinitionDTO {
    return DefinitionDTO(
        name = name,
        category = category.toDTO(),
        author = author.toDTO(),
    )
}

package com.barclay.tenziapi.models.dto

import com.barclay.tenziapi.models.database.Term

data class TermDTO(
    val name: String,
    val definitions: List<DefinitionDTO>,
    val creator: UserDTO,
)

fun Term.toDTO(): TermDTO {
    return TermDTO(
        name = name,
        definitions = definitions.map { it.toDTO() },
        creator = creator.toDTO(),
    )
}

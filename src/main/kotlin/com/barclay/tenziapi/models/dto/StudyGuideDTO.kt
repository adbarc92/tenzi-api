package com.barclay.tenziapi.models.dto

import com.barclay.tenziapi.models.database.StudyGuide

data class StudyGuideDTO(
    val id: String,
    val name: String,
    val categories: List<CategoryDTO>,
)

fun StudyGuide.toDTO(): StudyGuideDTO {
    return StudyGuideDTO(
        id = id,
        name = name,
        categories = categories.map { it.toDTO() },
    )
}
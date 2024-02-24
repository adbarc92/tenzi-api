package com.barclay.tenziapi.repositories

import com.barclay.tenziapi.models.database.StudyGuide
import com.barclay.tenziapi.models.database.User
import org.springframework.data.jpa.repository.JpaRepository

interface StudyGuideRepository : JpaRepository<StudyGuide, String> {
    fun findAllByOwner(owner: User): List<StudyGuide>
    fun findByIdAndOwner(id: String, owner: User): StudyGuide?
}
package com.barclay.tenziapi.services

import com.barclay.tenziapi.exceptions.StudyGuideNotFoundException
import com.barclay.tenziapi.exceptions.UserNotFoundException
import com.barclay.tenziapi.models.database.StudyGuide
import com.barclay.tenziapi.repositories.StudyGuideRepository
import com.barclay.tenziapi.repositories.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class StudyGuideService(
    private val userRepository: UserRepository,
    private val studyGuideRepository: StudyGuideRepository,
) {
    private val log = LoggerFactory.getLogger(this::class.java)

    fun createStudyGuide(ownerId: String): StudyGuide {
        val owner =
            userRepository.findUserByFirebaseId(firebaseId = ownerId) ?: throw UserNotFoundException("No user $ownerId")
        return studyGuideRepository.save(StudyGuide(owner = listOf(owner)))
    }

    fun getStudyGuideByIdAndOwnerId(studyGuideId: String, ownerId: String): StudyGuide {
        val owner =
            userRepository.findUserByFirebaseId(firebaseId = ownerId) ?: throw UserNotFoundException("No user $ownerId")
        return studyGuideRepository.findByIdAndOwner(id = studyGuideId, owner = owner)
            ?: throw StudyGuideNotFoundException("No study guide $studyGuideId found for user $ownerId")
    }
}
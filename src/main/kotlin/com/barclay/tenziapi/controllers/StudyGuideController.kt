package com.barclay.tenziapi.controllers

import com.barclay.tenziapi.exceptions.UnauthenticatedException
import com.barclay.tenziapi.exceptions.UserNotFoundException
import com.barclay.tenziapi.models.dto.StudyGuideDTO
import com.barclay.tenziapi.models.dto.toDTO
import com.barclay.tenziapi.services.OAuth2Service
import com.barclay.tenziapi.services.StudyGuideService
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("study-guide")
class StudyGuideController(
    private val studyGuideService: StudyGuideService,
    private val oauth2Service: OAuth2Service,
) {
    private val log = LoggerFactory.getLogger(this::class.java)

    @PreAuthorize("hasRole('TENZI_STUDYGUIDE_READ')")
    @PostMapping
    fun postGuideStudy(): ResponseEntity<StudyGuideDTO> {
        return try {
            ResponseEntity.ok(studyGuideService.createStudyGuide(oauth2Service.getUserId()).toDTO())
        } catch (e: Exception) {
            ResponseEntity.status(
                when (e) {
                    is UserNotFoundException -> HttpStatus.NOT_FOUND
                    is UnauthenticatedException -> HttpStatus.UNAUTHORIZED
                    else -> HttpStatus.INTERNAL_SERVER_ERROR
                }
            ).build()
        }
    }
}
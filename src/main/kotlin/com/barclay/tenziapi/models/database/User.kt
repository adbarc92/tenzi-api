package com.barclay.tenziapi.models.database

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "tenzi_user")
class User(
    @Id
    @Column(name = "firebase_id")
    val firebaseId: String,

    @Column(name = "name")
    val name: String,

    @Column(name = "email")
    val email: String,

    @Column(name = "profile_picture_url")
    val profilePictureUrl: String? = null,
)
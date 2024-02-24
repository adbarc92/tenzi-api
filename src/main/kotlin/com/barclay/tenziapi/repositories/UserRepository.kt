package com.barclay.tenziapi.repositories

import com.barclay.tenziapi.models.database.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, String> {
    fun findUserByFirebaseId(firebaseId: String): User?
}
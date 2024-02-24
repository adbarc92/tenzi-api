package com.barclay.tenziapi.models.database

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant
import java.util.*

@Entity
class StudyGuide(
    @Id
    val id: String  = UUID.randomUUID().toString(),

    @Column
    var name: String = "Unnamed study guide",

    @CreationTimestamp
    @Column(name = "created_timestamp_utc", nullable = false, updatable = false)
    val createdTs: Instant = Instant.now(),

    @UpdateTimestamp
    @Column(name = "last_updated_timestamp_utc", nullable = false)
    val lastUpdatedTs: Instant = Instant.now(),

    @OneToMany
    val categories: List<Category> = emptyList(),

    @OneToMany
    val terms: List<Term> = emptyList(),

    @ManyToOne
    val owner: User,

    @OneToMany
    val collaborators: List<User>,
)
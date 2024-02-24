package com.barclay.tenziapi.models.database

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToOne
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant
import java.util.*

@Entity
class Definition(
    @Id
    val id: String  = UUID.randomUUID().toString(),

    @Column
    var name: String = "Unnamed definition",

    @CreationTimestamp
    @Column(name = "created_timestamp_utc", nullable = false, updatable = false)
    val createdTs: Instant = Instant.now(),

    @UpdateTimestamp
    @Column(name = "last_updated_timestamp_utc", nullable = false)
    val lastUpdatedTs: Instant = Instant.now(),

    @ManyToOne
    val category: Category,

    @OneToOne
    val author: User,
)
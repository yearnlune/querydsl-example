package io.github.yearnlune.querydsl.example.mongodb.domain.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document("feeds")
data class Feed(
    @Id
    val id: String,

    val requiresAuthentication: Boolean,

    val modifiedDate: LocalDateTime = LocalDateTime.now(),

    val permanentlyRemoved: Boolean = false,

    val feedURL: String,

    val title: String,

    val bozoBitSet: Boolean = false,

    val enabled: Boolean = true,

    val etag: String,

    val link: String,

    val permanentRedirectURL: String,

    val description: String
)
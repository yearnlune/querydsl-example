package io.github.yearnlune.querydsl.example.mongodb.domain.entity

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document("feedEntries")
data class FeedEntry(
    @Id
    val id: String,

    val description: String,

    val title: String,

    val summary: String,

    val content: List<Content>,

    val entryId: String,

    val publishedDate: LocalDateTime,

    val link: String,

    val feedId: ObjectId
) {

    data class Content(
        val base: String,

        val type: String,

        val value: String,

        val language: String
    )
}
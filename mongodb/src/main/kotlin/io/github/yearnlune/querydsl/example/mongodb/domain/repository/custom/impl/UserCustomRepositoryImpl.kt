package io.github.yearnlune.querydsl.example.mongodb.domain.repository.custom.impl

import io.github.yearnlune.querydsl.example.mongodb.domain.repository.custom.UserCustomRepository
import org.springframework.data.mongodb.core.MongoTemplate

class UserCustomRepositoryImpl(
    val mongoTemplate: MongoTemplate
) : UserCustomRepository
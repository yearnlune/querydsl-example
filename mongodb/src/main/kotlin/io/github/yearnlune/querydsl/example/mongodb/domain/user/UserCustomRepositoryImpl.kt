package io.github.yearnlune.querydsl.example.mongodb.domain.user

import org.springframework.data.mongodb.core.MongoTemplate

class UserCustomRepositoryImpl(
    private val mongoTemplate: MongoTemplate
) : UserCustomRepository
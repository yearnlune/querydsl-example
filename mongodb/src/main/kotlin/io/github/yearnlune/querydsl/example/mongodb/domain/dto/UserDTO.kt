package io.github.yearnlune.querydsl.example.mongodb.domain.dto

import io.github.yearnlune.querydsl.example.mongodb.domain.type.UserType

data class UserDTO(

    val firstName: String,

    val surName: String,

    val type: UserType,
)
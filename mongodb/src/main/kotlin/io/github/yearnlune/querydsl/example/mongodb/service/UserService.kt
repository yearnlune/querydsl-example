package io.github.yearnlune.querydsl.example.mongodb.service

import io.github.yearnlune.querydsl.example.mongodb.domain.user.UserDTO
import io.github.yearnlune.querydsl.example.mongodb.domain.entity.QUser
import io.github.yearnlune.querydsl.example.mongodb.domain.user.User
import io.github.yearnlune.querydsl.example.mongodb.domain.user.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {

    fun findUserWithId(id: String): Result<User> {
        /* WITH QUERYDSL */
        return runCatching {
            val qUser: QUser = QUser.user
            userRepository.findOne(qUser.userId.eq(id)).orElseThrow { IllegalArgumentException() }
        }
    }

    fun enroll(user: UserDTO): Result<User> {
        return runCatching {
            userRepository.save(User.create(user))
        }
    }
}
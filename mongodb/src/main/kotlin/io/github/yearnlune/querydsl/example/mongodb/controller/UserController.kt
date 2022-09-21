package io.github.yearnlune.querydsl.example.mongodb.controller

import io.github.yearnlune.querydsl.example.mongodb.domain.dto.UserDTO
import io.github.yearnlune.querydsl.example.mongodb.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(
    val userService: UserService
) {

    @PostMapping
    fun enrollUser(user: UserDTO): ResponseEntity<Any> {
        return userService.enroll(user)
            .fold({
                ResponseEntity.status(HttpStatus.CREATED).build()
            }, {
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build()
            })
    }
}
package io.github.yearnlune.querydsl.example.mongodb.controller

import io.github.yearnlune.querydsl.example.mongodb.domain.user.UserDTO
import io.github.yearnlune.querydsl.example.mongodb.domain.user.User
import io.github.yearnlune.querydsl.example.mongodb.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(
    val userService: UserService
) {

    @GetMapping("/{id}")
    fun findUser(@PathVariable id: String): ResponseEntity<User> {
        return userService.findUserWithId(id)
            .fold({
                ResponseEntity.status(HttpStatus.OK).body(it)
            }, {
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build()
            })
    }

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
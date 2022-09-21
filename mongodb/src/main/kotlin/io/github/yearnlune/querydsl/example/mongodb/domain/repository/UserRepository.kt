package io.github.yearnlune.querydsl.example.mongodb.domain.repository

import io.github.yearnlune.querydsl.example.mongodb.domain.entity.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor

interface UserRepository : MongoRepository<User, String>, QuerydslPredicateExecutor<User>
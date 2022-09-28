package io.github.yearnlune.querydsl.example.mongodb.domain.user

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor

interface UserRepository : MongoRepository<User, String>, QuerydslPredicateExecutor<User>, UserCustomRepository
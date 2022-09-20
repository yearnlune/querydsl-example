package io.github.yearnlune.querydsl.example.mongodb

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

inline fun <reified T> T.logger(): Logger {
    if (T::class.isCompanion) {
        return LoggerFactory.getLogger(T::class.java.enclosingClass)
    }
    return LoggerFactory.getLogger(T::class.java)
}

@SpringBootApplication
class MongodbApplication

fun main(args: Array<String>) {
    runApplication<MongodbApplication>(*args)
}
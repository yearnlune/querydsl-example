package io.github.yearnlune.querydsl.example.mongodb.domain.type

abstract class EnumCompanion<E, V>(
    private val map: Map<V, E>
) {
    fun fromValue(value: V): E = map[value] ?: throw IllegalAccessError("")
}
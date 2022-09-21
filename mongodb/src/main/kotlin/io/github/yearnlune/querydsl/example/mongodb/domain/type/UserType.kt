package io.github.yearnlune.querydsl.example.mongodb.domain.type

enum class UserType(
    val value: String
) {
    USER("user"),
    OWNER("owner"),
    TESTER("tester");

    companion object : EnumCompanion<UserType, String>(UserType.values().associateBy(UserType::value))
}
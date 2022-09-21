package io.github.yearnlune.querydsl.example.mongodb.converter

import io.github.yearnlune.querydsl.example.mongodb.domain.type.UserType
import org.springframework.data.convert.PropertyValueConverter
import org.springframework.data.mongodb.core.convert.MongoConversionContext

object UserTypeConverter : PropertyValueConverter<UserType, String, MongoConversionContext> {

    override fun read(value: String, context: MongoConversionContext): UserType = UserType.fromValue(value)

    override fun write(value: UserType, context: MongoConversionContext): String = value.value
}
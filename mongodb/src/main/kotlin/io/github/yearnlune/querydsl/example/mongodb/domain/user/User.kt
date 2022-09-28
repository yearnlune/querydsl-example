package io.github.yearnlune.querydsl.example.mongodb.domain.user

import com.querydsl.core.annotations.QueryEntity
import io.github.yearnlune.querydsl.example.mongodb.converter.UserTypeConverter
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.convert.ValueConverter
import org.springframework.data.mongodb.core.index.CompoundIndex
import org.springframework.data.mongodb.core.index.CompoundIndexes
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@CompoundIndexes(
    CompoundIndex(def = "{'name': 1, 'stars': -1}")
)
@QueryEntity
@Document("users")
data class User(
    @Id
    val userId: String = ObjectId().toString(),

    @ValueConverter(UserTypeConverter::class)
    val type: UserType,

    val name: String,

    val stars: Long = 0L,

    val compliments: Compliments? = null,

    val elite: List<String>? = null,

    val fans: Long = 0L,

    @DBRef
    val friends: List<User>? = null
) {

    companion object {

        fun create(userDTO: UserDTO): User = User(
            type = userDTO.type,
            name = createName(userDTO.firstName, userDTO.surName)
        )

        private fun createName(firstName: String, surName: String): String {
            return "$firstName ${surName.toCharArray()[0]}."
        }
    }

    data class Compliments(
        val cool: Int?,

        val cute: Int?,

        val funny: Int?,

        val hot: Int?,

        val more: Int?,

        val note: Int?,

        val photos: Int?,

        val plain: Int?,

        val profile: Int?,

        val writer: Int?
    )
}
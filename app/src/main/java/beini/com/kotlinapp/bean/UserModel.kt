package beini.com.kotlinapp.bean

/**
 * Created by beini on 2017/6/3.
 */
data class UserModel constructor(val user: User) {
    data class User(
            val name: String,
            val age: Int
    )
}
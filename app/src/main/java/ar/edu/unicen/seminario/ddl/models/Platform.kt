package ar.edu.unicen.seminario.ddl.models
import com.google.gson.annotations.SerializedName


class Platform(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
) {
    fun toPlatform(): Platform {
        return Platform(
            id = id,
            name = name
        )
    }
}
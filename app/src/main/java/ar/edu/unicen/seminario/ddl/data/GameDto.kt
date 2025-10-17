package ar.edu.unicen.seminario.ddl.data

import ar.edu.unicen.seminario.ddl.models.Game
import com.google.gson.annotations.SerializedName

class GameDto(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description : String,
    @SerializedName("released") val released: String?,
    @SerializedName("background_image") val backgroundImage: String?,
    @SerializedName("rating") val rating: Double,
    @SerializedName("platforms") val platforms: List<PlatformWrapperDto>?
) {

    fun toGame(): Game {
        return Game(
            id = id,
            name = name,
            description = description,
            released = released,
            backgroundImage = backgroundImage,
            rating = rating,
            platforms = platforms?.map { it.toPlatform() } ?: emptyList()
        )
    }
}


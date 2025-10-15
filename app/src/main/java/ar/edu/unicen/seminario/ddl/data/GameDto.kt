package ar.edu.unicen.seminario.ddl.data

import ar.edu.unicen.catalog.ddl.models.Game
import ar.edu.unicen.seminario.ddl.models.PlatformWrapper
import com.google.gson.annotations.SerializedName

class GameDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("released")
    val released: String?,
    @SerializedName("background_image")
    val backgroundImage: String?,
    @SerializedName("rating")
    val rating: Double,
    @SerializedName("platforms")
    val platforms: List<PlatformWrapper.PlatformWrapper>?
) {

    fun toGame(): Game {
        return Game(
            id = id,
            name = name,
            released = released,
            backgroundImage = backgroundImage,
            rating = rating,
            platforms = platforms?.map { it.toPlatform() } ?: emptyList()
        )

    }
}
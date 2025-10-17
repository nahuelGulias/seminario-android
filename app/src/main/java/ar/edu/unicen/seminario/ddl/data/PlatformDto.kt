package ar.edu.unicen.seminario.ddl.data

import ar.edu.unicen.seminario.ddl.models.Platform
import com.google.gson.annotations.SerializedName

class PlatformDto (
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
){
    fun toPlatform(): Platform {
        return Platform(
            id = id,
            name = name
        )
    }

}
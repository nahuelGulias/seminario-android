package ar.edu.unicen.seminario.ddl.data

import ar.edu.unicen.seminario.ddl.models.Platform
import com.google.gson.annotations.SerializedName

class PlatformWrapperDto(
    @SerializedName("platform") val platform: PlatformDto

) {
    fun toPlatform(): Platform {
        return platform.toPlatform()
    }
}
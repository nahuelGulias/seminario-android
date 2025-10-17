package ar.edu.unicen.seminario.ddl.models
import com.google.gson.annotations.SerializedName

data class PlatformWrapper(
    @SerializedName("platform")
    val platform: Platform
    ){

}

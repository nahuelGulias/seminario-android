package ar.edu.unicen.seminario.ddl.models
import com.google.gson.annotations.SerializedName

data class Game(
    val id: Int,
    val name: String,
    val description: String,
    val released: String?,
    val backgroundImage: String?,
    val rating: Double,
    val platforms: List<Platform>
)
{
}
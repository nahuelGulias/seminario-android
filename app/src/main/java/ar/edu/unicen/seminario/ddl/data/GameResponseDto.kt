package ar.edu.unicen.seminario.ddl.data

import ar.edu.unicen.catalog.ddl.models.Game
import ar.edu.unicen.catalog.ddl.models.GameResponse
import com.google.gson.annotations.SerializedName

class GameResponseDto (
    @SerializedName("count")
    val count : Int,
    @SerializedName("next")
    val next : String,
    @SerializedName("previous")
    val previous : String,
    @SerializedName("results")
    val results : List<Game>

){

    fun toGame() : GameResponse{
        return GameResponse(
            count = count,
            next = next,
            previous = previous,
            results = results
        )
    }
}
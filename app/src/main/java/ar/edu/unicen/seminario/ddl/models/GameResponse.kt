package ar.edu.unicen.seminario.ddl.models

class GameResponse {
    data class GameResponse(
        val count: Int,
        val next: String,
        val previous: String,
        val results: List<Game>
    )
}
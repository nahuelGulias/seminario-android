package ar.edu.unicen.seminario.ddl.models
data class GameResponse(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<Game>
    ){

    }
package ar.edu.unicen.seminario.ddl.data

import ar.edu.unicen.seminario.ddl.models.Game
import ar.edu.unicen.seminario.ddl.models.GameResponse
import javax.inject.Inject

class GameRepository @Inject constructor(
    private val RemoteDataSource: GameDataSource
) {

    suspend fun getGames(
        apiKey: String,
        page: Int,
        pageSize: Int
    ): GameResponse {

        return RemoteDataSource.getGames(apiKey, page, pageSize)
    }
}
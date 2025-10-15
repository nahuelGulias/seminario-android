package ar.edu.unicen.seminario.ddl.data

import ar.edu.unicen.catalog.ddl.models.Game
import javax.inject.Inject

class GameRepository @Inject constructor(
    private val RemoteDataSource: GameRemoteDataSource
) {

    suspend fun getGames(
        apiKey: String,
        page: Int,
        pageSize: Int
    ): Game? {

        return RemoteDataSource.getGames(apiKey, page, pageSize)
    }
}
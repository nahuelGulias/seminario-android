package ar.edu.unicen.seminario.ddl.data



import ar.edu.unicen.seminario.ddl.api.GameApiService
import ar.edu.unicen.seminario.ddl.models.GameResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GameDataSource @Inject constructor(
    private val ApiService: GameApiService
){
    suspend fun getGames(
        apiKey: String,
        page: Int,
        pageSize: Int
    ): GameResponse {
        return withContext(Dispatchers.IO){
            val response = ApiService.getGames(apiKey, page, pageSize)
            val gameDto = response.body()

            if(gameDto == null){
                throw Exception("Error fetching games")
            }
            return@withContext gameDto.toGameResponse()

        }
    }
}
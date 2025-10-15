package ar.edu.unicen.seminario.ddl.data



import ar.edu.unicen.seminario.ddl.models.Game
import ar.edu.unicen.seminario.ddl.api.GameApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GameRemoteDataSource @Inject constructor(
    private val ApiService: GameApiService
){
    suspend fun getGames(
        apiKey: String,
        page: Int,
        pageSize: Int
    ): Game? {
        return withContext(Dispatchers.IO){
            val response = ApiService.getGames(apiKey, page, pageSize)
            val gameDto = response.body()

            if(gameDto == null){
                throw Exception("Error fetching games")
            }
            return@withContext gameDto.toGame()

        }
    }
}
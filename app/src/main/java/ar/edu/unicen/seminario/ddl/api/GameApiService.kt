package ar.edu.unicen.seminario.ddl.api

import ar.edu.unicen.seminario.ddl.data.GameResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GameApiService {
    @GET("games")
    suspend fun getGames(
        @Query("key")
        apiKey: String,
        @Query("page")
        page: Int,
        @Query("page_size")
        pageSize: Int
    ): Response<GameResponseDto>
}
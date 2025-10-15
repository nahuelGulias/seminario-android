import ar.edu.unicen.catalog.BuildConfig
import ar.edu.unicen.catalog.ddl.data.GameApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



@Module
@InstallIn(SingletonComponent::class)
class GameModule{
    private val BASE_URL = BuildConfig.BASE_URL

    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun providesGameApi(
        retrofit: Retrofit
    ): GameApiService {
        return retrofit.create(GameApiService::class.java)
    }
}
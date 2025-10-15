package ar.edu.unicen.seminario


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.unicen.seminario.ddl.data.GameRepository
import ar.edu.unicen.seminario.ddl.models.Game
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

// 1. Anota con @HiltViewModel para que Hilt sepa cómo inyectar dependencias aquí.
@HiltViewModel
class GameViewModel @Inject constructor(
    private val repository: GameRepository // 2. Hilt inyectará el GameRepository que definiste en tu módulo.
) : ViewModel() {

    // 3. Define un StateFlow privado y mutable para mantener el estado interno.
    private val _games = MutableStateFlow<Game?>(null)

    // 4. Expone una versión pública e inmutable (StateFlow) para que la UI la observe.
    val games: StateFlow<Game?> = _games.asStateFlow()

    // Llama a esta función desde la UI para iniciar la carga de datos.
    fun getGames(
        page: Int,
        pageSize: Int
    ) {
        // 5. Usa viewModelScope para lanzar una corrutina segura que se cancela si el ViewModel se destruye.
        viewModelScope.launch {
            try {
                // 6. Llama a la función del repositorio (que está en un hilo de fondo gracias al withContext).
                val gameData = repository.getGames(
                    apiKey = "BuildConfig.API_KEY",
                    page = page,
                    pageSize = pageSize
                )
                // 7. Actualiza el StateFlow con los datos recibidos. La UI reaccionará a este cambio.
                _games.value = gameData
            } catch (e: Exception) {
                // Maneja cualquier error de la llamada de red.
                // Por ejemplo, podrías tener otro StateFlow para el estado de error.
                println("Error fetching games: ${e.message}")
            }
        }
    }
}
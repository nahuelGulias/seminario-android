package ar.edu.unicen.seminario.ui.screen

import ar.edu.unicen.seminario.ddl.models.Platform
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ar.edu.unicen.seminario.GameViewModel
import ar.edu.unicen.seminario.ddl.models.Game


@Composable
fun Home(
    games : List<Game>,
    viewModel : GameViewModel
){

    LaunchedEffect(Unit) {
        if (games.isEmpty()) { // Opcional: solo carga si la lista está vacía
            viewModel.getGames(page = 1, pageSize = 20)
        }
    }
    LazyVerticalGrid(
        columns = GridCells.Fixed(2), // 👈 2 columnas = 2 juegos por fila
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(games){ game ->
            GameCard(game)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    // 1. Creamos una lista de juegos de ejemplo.
    val mockGames = listOf(
        Game(
            id = 1,
            name = "Grand Theft Auto V",
            description = "Un juego de mundo abierto...",
            released = "2013-09-17",
            backgroundImage = "https://media.rawg.io/media/games/456/456dea5e1c7e3cd07060c14e96612001.jpg",
            rating = 4.47,
            platforms = listOf(
                Platform(id = 4, name = "PC"),
                Platform(id = 187, name = "PlayStation 5")
            )
        ),
        Game(
            id = 2,
            name = "The Witcher 3: Wild Hunt",
            description = "Un RPG de mundo abierto...",
            released = "2015-05-18",
            backgroundImage = "https://media.rawg.io/media/games/618/618c2031a07bbff6b4f611f10b6bcdbc.jpg",
            rating = 4.66,
            platforms = listOf(
                Platform(id = 4, name = "PC"),
                Platform(id = 1, name = "Xbox One")
            )
        ),
        Game(
            id = 3,
            name = "Red Dead Redemption 2",
            description = "La historia de Arthur Morgan...",
            released = "2018-10-26",
            backgroundImage = "https://media.rawg.io/media/games/511/5118aff5091cb3efec399c808f8c598f.jpg",
            rating = 4.59,
            platforms = listOf(
                Platform(id = 18, name = "PlayStation 4"),
                Platform(id = 4, name = "PC")
            )
        ),
        Game(
            id = 4,
            name = "Portal 2",
            description = "Un juego de puzzles en primera persona.",
            released = "2011-04-18",
            backgroundImage = "https://media.rawg.io/media/games/328/3283617cb7d75d67257fc58339188742.jpg",
            rating = 4.61,
            platforms = listOf(
                Platform(id = 4, name = "PC"),
                Platform(id = 16, name = "PlayStation 3")
            )
        )
    )

    // 2. Llamamos a la vista Home con los datos de ejemplo.
    Home(
        games = mockGames,
        viewModel = viewModel()
    )
}



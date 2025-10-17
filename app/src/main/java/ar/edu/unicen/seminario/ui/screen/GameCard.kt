package ar.edu.unicen.seminario.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ar.edu.unicen.seminario.ddl.models.Game
import coil.compose.AsyncImage

@Composable
fun GameCard(game: Game) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(0.7f),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(8.dp)
        ){
            AsyncImage(
                model = game.backgroundImage,
                contentDescription = game.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = game.name,
                style = MaterialTheme.typography.titleMedium,
                maxLines = 1
            )
            Text(
                text = game.released ?: "",
                style = MaterialTheme.typography.bodySmall
            )
            Text(
                text = game.description,
                style = MaterialTheme.typography.bodySmall
            )
            Text(
                text = "⭐ ${game.rating}",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.primary
            )
        }

    }
}


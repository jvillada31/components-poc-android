package com.bedrock.congrats.view.row

import android.content.res.Configuration
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@ExperimentalMaterial3Api
@Composable
fun HeaderRow(
//    viewModel: CharactersViewModel = getViewModel(),
//    dto: CharacterDto,
    onDetailClick: () -> Unit = {}
) {
    Card(
        onClick = onDetailClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(
                vertical = 4.dp,
                horizontal = 8.dp
            ),
        elevation = CardDefaults.cardElevation()
    ) {
        Row {
            Text(
                text = "Congrats component",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 2.dp),
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }
}

@Preview(
    showBackground = true,
    name = "Light Mode"
)
@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Dark Mode"
)
@Composable
fun CharacterRowPreview() {
//    JetRortyTheme {
//        CharacterRow(dto = CharacterDto.init())
//    }
}

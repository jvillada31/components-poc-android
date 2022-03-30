package com.bedrock.congrats.view.row

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import com.bedrock.congrats.ui.theme.BorderColor
import com.bedrock.congrats.ui.theme.ComponentsPOCTheme
import com.bedrock.congrats.view.state.OperationViewState

@ExperimentalMaterial3Api
@Composable
fun OperationRow(
    operations: List<OperationViewState>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row {
            LazyColumn(
                modifier = Modifier
                    .padding(start = 32.dp, end = 32.dp, top = 20.dp, bottom = 26.dp),
                verticalArrangement = spacedBy(24.dp)
            ) {
                items(operations.size) { item ->
                    OperationView(operations[item])
                }
            }
        }


    }
}

@Composable
fun OperationView(
    operationViewState: OperationViewState
) {
    Row {
        SubcomposeAsyncImage(
            model = operationViewState.icon,
            loading = {
                CircularProgressIndicator()
            },
            contentDescription = operationViewState.contentDescriptionIcon,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .border(1.5.dp, BorderColor, CircleShape),
        )

        Column(
            modifier = Modifier
                .padding(start = 16.dp, top = 4.dp, bottom = 4.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = operationViewState.labelTitle,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )

            operationViewState.labelSubTitle?.let {
                Text(
                    modifier = Modifier
                        .padding(top = 2.dp),
                    text = it,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                )
            }
        }

    }
}

@ExperimentalMaterial3Api
@Preview(
    showBackground = true,
    name = "Light Mode"
)
@Composable
fun OperationViewPreview() {
    // TODO: Provide this theme through another common module
    ComponentsPOCTheme {
        OperationView(
            operationViewState = OperationViewState(
                icon = "https://mobile.mercadolibre.com/remote_resources/image/wallet_home_shortcuts_charge_qr?density=xxxhdpi&locale=es_AR",
                labelTitle = "$ 12.000",
                labelSubTitle = "Santander Rio ****3260"
            )
        )
    }
}

@ExperimentalMaterial3Api
@Preview(
    showBackground = true,
    name = "Light Mode"
)
@Composable
fun OperationRowPreview() {
    // TODO: Provide this theme through another common module
    ComponentsPOCTheme {
        OperationRow(
            operations = listOf(
                OperationViewState(
                    icon = "https://mobile.mercadolibre.com/remote_resources/image/wallet_home_shortcuts_charge_qr?density=xxxhdpi&locale=es_AR",
                    labelTitle = "$ 12.000",
                    labelSubTitle = "Santander Rio ****3260"
                ),
                OperationViewState(
                    icon = "https://mobile.mercadolibre.com/remote_resources/image/wallet_home_shortcuts_charge_qr?density=xxxhdpi&locale=es_AR",
                    labelTitle = "$ 12.000",
                    labelSubTitle = "Santander Rio ****3260"
                )
            )
        )
    }
}
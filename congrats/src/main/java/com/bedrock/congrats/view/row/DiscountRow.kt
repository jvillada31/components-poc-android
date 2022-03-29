package com.bedrock.congrats.view.row

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.IconButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import com.bedrock.congrats.ui.theme.ComponentsPOCTheme
import com.bedrock.congrats.view.state.ButtonType
import com.bedrock.congrats.view.state.ButtonViewState
import com.bedrock.congrats.view.state.DiscountViewState
import com.bedrock.congrats.view.state.DiscountSectionViewState

@ExperimentalMaterial3Api
@Composable
fun DiscountRow(
    discountSectionViewState: DiscountSectionViewState
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(start = 32.dp, top = 15.dp, end = 32.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = discountSectionViewState.title,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        Row {
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                modifier = Modifier
                    .padding(start = 44.dp, end = 44.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                val count = if (discountSectionViewState.discounts.size > 6) 6 else discountSectionViewState.discounts.size
                items(count) { index ->
                    DiscountView(discountSectionViewState.discounts[index])
                }
            }
        }

        Row(
            modifier = Modifier
                .padding(start = 32.dp, end = 32.dp, top = 24.dp, bottom = 24.dp)
        ) {
            ButtonView(
                buttonViewState = discountSectionViewState.buttonViewState
            )
        }
    }
}

@Composable
private fun DiscountView(
    discountViewState: DiscountViewState
) {
    Column(
        modifier = Modifier
            .padding(top = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .width(80.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            IconButton(
                onClick = discountViewState.action,
                modifier = Modifier
                    .width(54.dp)
                    .height(54.dp)
            ) {
                SubcomposeAsyncImage(
                    model = discountViewState.icon,
                    loading = {
                        CircularProgressIndicator()
                    },
                    contentDescription = discountViewState.contentDescription
                )
            }
        }
        Spacer(modifier = Modifier.size(8.dp))
        Row(
            modifier = Modifier
                .width(80.dp)
                .height(14.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = discountViewState.labelTitle,
                fontSize = 12.sp,
                fontWeight = FontWeight.Light
            )
        }

        Row(
            modifier = Modifier
                .width(80.dp)
                .height(24.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = discountViewState.labelPrice,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@ExperimentalMaterial3Api
@Preview(
    showBackground = true,
    name = "Light Mode"
)
@Composable
fun DiscountRowPreview() {
    // TODO: Provide this theme through another common module
    ComponentsPOCTheme {
        DiscountRow(
            DiscountSectionViewState(
                title = "Descuentos por tu nivel",
                discounts = listOf(
                    DiscountViewState(
                        icon = "https://mobile.mercadolibre.com/remote_resources/image/px_congrats_money_split_mp?density=xxhdpi&locale=es_AR",
                        contentDescription = "Icono de macdonals",
                        labelTitle = "Hasta",
                        labelPrice = "$ 200"
                    ),
                    DiscountViewState(
                        icon = "R.drawable.congrats_ic_product",
                        contentDescription = "Icono de macdonals",
                        labelTitle = "Hasta",
                        labelPrice = "$ 100"
                    ),
                    DiscountViewState(
                        icon = "R.drawable.congrats_ic_product",
                        contentDescription = "Icono de macdonals",
                        labelTitle = "Hasta",
                        labelPrice = "$ 200"
                    ),
                    DiscountViewState(
                        icon = "R.drawable.congrats_ic_product",
                        contentDescription = "Icono de macdonals",
                        labelTitle = "Hasta",
                        labelPrice = "$ 100"
                    ),
                    DiscountViewState(
                        icon = "R.drawable.congrats_ic_product",
                        contentDescription = "Icono de macdonals",
                        labelTitle = "Hasta",
                        labelPrice = "$ 200"
                    ),
                    DiscountViewState(
                        icon = "R.drawable.congrats_ic_product",
                        contentDescription = "Icono de macdonals",
                        labelTitle = "Hasta",
                        labelPrice = "$ 100"
                    )
                ),
                buttonViewState = ButtonViewState(
                    label = "Ver todos los descuentos",
                    type = ButtonType.SECONDARY,
                    action = {}
                )
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
fun DiscountPreview() {
    // TODO: Provide this theme through another common module
    ComponentsPOCTheme {
        DiscountView(
            DiscountViewState(
                icon = "R.drawable.congrats_ic_product",
                contentDescription = "Icono de macdonals",
                labelTitle = "Hasta",
                labelPrice = "$ 100"
            )
        )
    }
}

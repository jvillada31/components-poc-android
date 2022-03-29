package com.bedrock.congrats.view.row

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.IconButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bedrock.congrats.R
import com.bedrock.congrats.ui.theme.ComponentsPOCTheme
import com.bedrock.congrats.view.state.DiscountState

@ExperimentalMaterial3Api
@Composable
fun DiscountRow(
    discountsState: List<DiscountState>
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
                text = "Descuentos por tu nivel",
                fontSize = 20.sp
            )
        }

        Row {
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                modifier = Modifier
                    .padding(start = 44.dp, end = 44.dp)
                    .wrapContentSize(),
                horizontalArrangement = Arrangement.Center
            ) {
                val count = if (discountsState.size > 6) 6 else discountsState.size
                items(count) { index ->
                    DiscountView(discountsState[index])
                }
            }
        }
    }
}

@Composable
private fun DiscountView(
    discountState: DiscountState
) {
    Column(
        modifier = Modifier
            .padding(top = 24.dp)
    ) {
        Row(
            modifier = Modifier
                .width(80.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            IconButton(
                onClick = discountState.action,
                modifier = Modifier
                    .width(54.dp)
                    .height(54.dp)
            ) {
                Icon(
                    painter = painterResource(id = discountState.icon),
                    contentDescription = discountState.contentDescription
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
                text = discountState.labelTime,
                fontSize = 12.sp
            )
        }

        Row(
            modifier = Modifier
                .width(80.dp)
                .height(24.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = discountState.labelPrice,
                fontSize = 20.sp
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
            listOf(
                DiscountState(
                    icon = R.drawable.congrats_ic_product,
                    contentDescription = "Icono de macdonals",
                    labelTime = "Hasta",
                    labelPrice = "$ 200"
                ),
                DiscountState(
                    icon = R.drawable.congrats_ic_product,
                    contentDescription = "Icono de macdonals",
                    labelTime = "Hasta",
                    labelPrice = "$ 100"
                ),
                DiscountState(
                    icon = R.drawable.congrats_ic_product,
                    contentDescription = "Icono de macdonals",
                    labelTime = "Hasta",
                    labelPrice = "$ 200"
                ),
                DiscountState(
                    icon = R.drawable.congrats_ic_product,
                    contentDescription = "Icono de macdonals",
                    labelTime = "Hasta",
                    labelPrice = "$ 100"
                ),
                DiscountState(
                    icon = R.drawable.congrats_ic_product,
                    contentDescription = "Icono de macdonals",
                    labelTime = "Hasta",
                    labelPrice = "$ 200"
                ),
                DiscountState(
                    icon = R.drawable.congrats_ic_product,
                    contentDescription = "Icono de macdonals",
                    labelTime = "Hasta",
                    labelPrice = "$ 100"
                )
            )
        )
    }
}
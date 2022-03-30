package com.bedrock.components

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.bedrock.congrats.R
import com.bedrock.congrats.ui.theme.ComponentsPOCTheme
import com.bedrock.congrats.ui.theme.Green
import com.bedrock.congrats.view.row.ButtonRow
import com.bedrock.congrats.view.row.DiscountRow
import com.bedrock.congrats.view.row.HeaderRow
import com.bedrock.congrats.view.state.ButtonType
import com.bedrock.congrats.view.state.ButtonViewState
import com.bedrock.congrats.view.state.DiscountViewState
import com.bedrock.congrats.view.state.DiscountSectionViewState
import timber.log.Timber

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComponentsPOCTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Column(
                        modifier = Modifier
                            .background(color = Color.White)
                            .fillMaxWidth()
                            .fillMaxHeight(),
                    ) {
                        Row {
                            HeaderRow(
                                backgroundColor = Green,
                                title = "Congrats pantalla verde, Congrats pantalla verde, Congrats pantalla verde",
                                label = "",
                                icon = R.drawable.congrats_ic_product,
                                badge = R.drawable.congrats_ic_badge_check
                            ) {
                                Timber.d("Hello green Congrats :)")
                            }
                        }

                        Row {
                            Column {
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
                                                icon = "https://mobile.mercadolibre.com/remote_resources/image/wallet_home_shortcuts_charge_qr?density=xxxhdpi&locale=es_AR",
                                                contentDescription = "Icono de macdonals",
                                                labelTitle = "Hasta",
                                                labelPrice = "$ 100"
                                            ),
                                            DiscountViewState(
                                                icon = "https://mobile.mercadolibre.com/remote_resources/image/px_congrats_money_split_mp?density=xxhdpi&locale=es_AR",
                                                contentDescription = "Icono de macdonals",
                                                labelTitle = "Hasta",
                                                labelPrice = "$ 200"
                                            ),
                                            DiscountViewState(
                                                icon = "https://mobile.mercadolibre.com/remote_resources/image/px_congrats_money_split_mp?density=xxhdpi&locale=es_AR",
                                                contentDescription = "Icono de macdonals",
                                                labelTitle = "Hasta",
                                                labelPrice = "$ 100"
                                            ),
                                            DiscountViewState(
                                                icon = "https://mobile.mercadolibre.com/remote_resources/image/px_congrats_money_split_mp?density=xxhdpi&locale=es_AR",
                                                contentDescription = "Icono de macdonals",
                                                labelTitle = "Hasta",
                                                labelPrice = "$ 200"
                                            ),
                                            DiscountViewState(
                                                icon = "https://mobile.mercadolibre.com/remote_resources/image/px_congrats_money_split_mp?density=xxhdpi&locale=es_AR",
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

                        Row(
                            verticalAlignment = Alignment.Bottom
                        ) {
                            ButtonRow(
                                primaryButton = ButtonViewState(
                                    type = ButtonType.PRIMARY,
                                    label = "Ver más",
                                    contentDescription = "Este boton te da la opcion de ver más cosas",
                                    action = { Toast.makeText(this@MainActivity, "Viendo más cosas....", Toast.LENGTH_LONG).show() }
                                ),
                                secondaryButton = ButtonViewState(
                                    type = ButtonType.TRANSPARENT,
                                    label = "Volver al inicio",
                                    contentDescription = "Este boton te pueden devolver al incio de la aplicaión",
                                    action = { Toast.makeText(this@MainActivity, "Saliendo....", Toast.LENGTH_LONG).show() }
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComponentsPOCTheme {
        HeaderRow(
            backgroundColor = Green,
            title = "Congrats pantalla verde",
            label = "",
            icon = R.drawable.congrats_ic_product,
            badge = R.drawable.congrats_ic_badge_check
        ) {
            Timber.d("Hello Congrats")
        }
    }
}

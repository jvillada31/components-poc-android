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
import com.bedrock.congrats.view.row.HeaderRow
import com.bedrock.congrats.view.state.ButtonType
import com.bedrock.congrats.view.state.ButtonViewState
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

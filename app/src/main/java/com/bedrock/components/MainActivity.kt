package com.bedrock.components

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.bedrock.congrats.R
import com.bedrock.congrats.ui.theme.ComponentsPOCTheme
import com.bedrock.congrats.view.row.HeaderRow
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
                        HeaderRow(
                            title = "Congrats pantalla verde",
                            label = "",
                            icon = R.drawable.congrats_ic_product,
                            badge = R.drawable.congrats_ic_badge_check
                        ) {
                            Timber.d("Hello Congrats :)")
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
            title = "Congrats pantalla verde",
            label = "",
            icon = R.drawable.congrats_ic_product,
            badge = R.drawable.congrats_ic_badge_check
        ) {
            Timber.d("Hello Congrats")
        }
    }
}

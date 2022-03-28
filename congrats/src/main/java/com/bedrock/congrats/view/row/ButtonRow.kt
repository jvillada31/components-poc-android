package com.bedrock.congrats.view.row

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bedrock.congrats.ui.theme.ComponentsPOCTheme
import com.bedrock.congrats.ui.theme.PrimaryButton
import com.bedrock.congrats.ui.theme.SecondaryButton

@ExperimentalMaterial3Api
@Composable
fun ButtonRow(
    primaryButton: ButtonData,
    secondaryButton: ButtonData? = null
) {
    Column(
        modifier = Modifier
            .padding(start = 32.dp, top = 17.dp, end = 32.dp, bottom = 16.dp)
            .fillMaxWidth()
    ) {
        Row {
            when (primaryButton.type) {
                ButtonType.PRIMARY -> {
                    Button(
                        modifier = Modifier
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(5.dp),
                        colors = buttonColors(
                            containerColor = PrimaryButton,
                            contentColor = Color.White,
                        ),
                        onClick = primaryButton.action,
                    ) {
                        Text(
                            text = primaryButton.label,
                            fontSize = 16.sp
                        )
                    }
                }
                ButtonType.DEFAULT -> {
                    TextButton(
                        modifier = Modifier
                            .fillMaxWidth(),
                        onClick = primaryButton.action,
                    ) {
                        Text(
                            text = primaryButton.label,
                            fontSize = 16.sp,
                            color = PrimaryButton
                        )
                    }
                }
                else -> {}
            }
        }

        secondaryButton?.let {
            Spacer(modifier = Modifier.size(8.dp))
            Row {
                Button(
                    modifier = Modifier
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(5.dp),
                    colors = buttonColors(
                        containerColor = SecondaryButton,
                        contentColor = PrimaryButton,
                    ),
                    onClick = secondaryButton.action
                ) {
                    Text(
                        text = secondaryButton.label,
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}

@ExperimentalMaterial3Api
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
fun ButtonRowPreview() {
    // TODO: Provide this theme through another common module
    ComponentsPOCTheme {
        ButtonRow(
            primaryButton = ButtonData(
                label = "Ver más",
                type = ButtonType.PRIMARY,
                action = {}
            ),
            secondaryButton = ButtonData(
                label = "Volver al inicio",
                type = ButtonType.SECONDARY,
                action = {}
            )
        )
    }
}
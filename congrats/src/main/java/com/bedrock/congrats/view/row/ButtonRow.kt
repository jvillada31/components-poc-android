package com.bedrock.congrats.view.row

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bedrock.congrats.ui.theme.ComponentsPOCTheme

@ExperimentalMaterial3Api
@Composable
fun ButtonRow(
    primaryButton: ButtonViewState,
    secondaryButton: ButtonViewState? = null
) {
    Column(
        modifier = Modifier
            .padding(start = 32.dp, top = 17.dp, end = 32.dp, bottom = 16.dp)
            .fillMaxWidth()
    ) {
        Row {
            ButtonView(primaryButton)
        }

        secondaryButton?.let {
            Spacer(modifier = Modifier.size(8.dp))
            Row {
                ButtonView(it)
            }
        }
    }
}

@Composable
private fun ButtonView(
    buttonViewState: ButtonViewState
) {
    Button(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(5.dp),
        colors = buttonColors(
            containerColor = buttonViewState.type.backgroundColor,
            contentColor = buttonViewState.type.textColor,
        ),
        onClick = buttonViewState.action
    ) {
        Text(
            text = buttonViewState.label,
            fontSize = 16.sp
        )
    }
}

@ExperimentalMaterial3Api
@Preview(
    showBackground = true,
    name = "Light Mode"
)
@Composable
fun ButtonRowPreview() {
    // TODO: Provide this theme through another common module
    ComponentsPOCTheme {
        ButtonRow(
            primaryButton = ButtonViewState(
                label = "Ver más",
                type = ButtonType.PRIMARY,
                action = {}
            ),
            secondaryButton = ButtonViewState(
                label = "Volver al inicio",
                type = ButtonType.SECONDARY,
                action = {}
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
fun ButtonRowPreviewTransparent() {
    // TODO: Provide this theme through another common module
    ComponentsPOCTheme {
        ButtonRow(
            primaryButton = ButtonViewState(
                label = "Ver más",
                type = ButtonType.PRIMARY,
                action = {}
            ),
            secondaryButton = ButtonViewState(
                label = "Volver al inicio",
                type = ButtonType.TRANSPARENT,
                action = {}
            )
        )
    }
}
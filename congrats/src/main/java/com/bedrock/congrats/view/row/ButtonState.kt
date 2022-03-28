package com.bedrock.congrats.view.row

import androidx.compose.ui.graphics.Color
import com.bedrock.congrats.ui.theme.PrimaryButton
import com.bedrock.congrats.ui.theme.SecondaryButton
import com.bedrock.congrats.ui.theme.Transparent

data class ButtonState(
    val type: ButtonType,
    val label: String,
    val contentDescription: String? = null,
    val action: () -> Unit = {}
)

enum class ButtonType(val backgroundColor: Color, val textColor: Color) {
    PRIMARY(PrimaryButton, Color.White),
    SECONDARY(SecondaryButton, PrimaryButton),
    TRANSPARENT(Transparent, PrimaryButton)
}

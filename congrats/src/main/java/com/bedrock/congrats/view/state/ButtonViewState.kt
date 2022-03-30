package com.bedrock.congrats.view.state

import androidx.compose.ui.graphics.Color
import com.bedrock.congrats.ui.theme.PrimaryButtonColor
import com.bedrock.congrats.ui.theme.SecondaryButtonColor
import com.bedrock.congrats.ui.theme.TransparentButtonColor

data class ButtonViewState(
    val type: ButtonType,
    val label: String,
    val contentDescription: String? = null,
    val action: () -> Unit = {}
)

enum class ButtonType(val backgroundColor: Color, val textColor: Color) {
    PRIMARY(PrimaryButtonColor, Color.White),
    SECONDARY(SecondaryButtonColor, PrimaryButtonColor),
    TRANSPARENT(TransparentButtonColor, PrimaryButtonColor)
}

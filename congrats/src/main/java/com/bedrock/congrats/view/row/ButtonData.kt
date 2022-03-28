package com.bedrock.congrats.view.row

data class ButtonData(
    val label: String,
    val type: ButtonType,
    val action: () -> Unit = {}
)

enum class ButtonType {
    PRIMARY, SECONDARY, DEFAULT
}

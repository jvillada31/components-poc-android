package com.bedrock.congrats.view.state

data class DiscountState(
    val icon: Int,
    val contentDescription: String? = null,
    val labelTime: String,
    val labelPrice: String,
    val action: () -> Unit = {}
)

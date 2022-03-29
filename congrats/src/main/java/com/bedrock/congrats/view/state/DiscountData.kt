package com.bedrock.congrats.view.state

data class DiscountData(
    val title: String,
    val discounts: List<Discount>,
    val buttonViewState: ButtonViewState
)

data class Discount(
    val icon: Int,
    val contentDescription: String? = null,
    val labelTitle: String,
    val labelPrice: String,
    val action: () -> Unit = {}
)

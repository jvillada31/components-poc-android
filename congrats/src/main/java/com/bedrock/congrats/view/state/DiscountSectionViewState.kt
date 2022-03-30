package com.bedrock.congrats.view.state

data class DiscountSectionViewState(
    val title: String,
    val subTitle: String? = null,
    val discounts: List<DiscountViewState>,
    val buttonViewState: ButtonViewState
)

data class DiscountViewState(
    val icon: String,
    val contentDescription: String? = null,
    val labelTitle: String,
    val labelPrice: String,
    val action: () -> Unit = {}
)

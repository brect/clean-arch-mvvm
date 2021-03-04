package com.blimas.presenter.model

import com.blimas.domain.model.Category

class CategoryUiModel(
    val name: String,
    val thumb: String
)

fun Category.toUiModel() = CategoryUiModel(
    name = this.name,
    thumb = this.thumb
)


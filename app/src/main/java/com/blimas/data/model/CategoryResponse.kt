package com.blimas.data.model

import com.blimas.domain.model.Category

data class CategoryResponse(
    val idCategory: String,
    val strCategory: String,
    val strCategoryThumb: String,
    val strCategoryDescription: String
)

fun CategoryResponse.toCategory() = Category(
    id = this.idCategory,
    name = this.strCategory,
    thumb = this.strCategoryThumb,
    description = this.strCategoryDescription
)
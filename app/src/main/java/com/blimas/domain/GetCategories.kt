package com.blimas.domain

import com.blimas.data.MealRepository
import com.blimas.domain.model.Category

class GetCategories(
    private val mealRepository: MealRepository
) : GetCategoriesUseCase {

    override suspend fun invoke(): List<Category> = try {
        mealRepository.getCategories()
    } catch (ex: Exception) {
        listOf()
    }
}

interface GetCategoriesUseCase {
    suspend operator fun invoke(): List<Category>
}
package com.blimas.data

import com.blimas.data.api.MealApi
import com.blimas.data.model.toCategory
import com.blimas.domain.model.Category
import com.blimas.network.Output
import com.blimas.network.parseResponse

class MealRepositoryImpl(
    private val service: MealApi
) : MealRepository {

    override suspend fun getCategories(): List<Category> {
        val result = service.getCategories().parseResponse()

        return when (result) {
            is Output.Success -> {
                val categoryResponseList = result.value.categories

                categoryResponseList.map {
                    it.toCategory()
                }
            }
            is Output.Failure -> throw GetCategoriesException()
        }
    }
}

interface MealRepository {
    suspend fun getCategories(): List<Category>
}

class GetCategoriesException : Exception()

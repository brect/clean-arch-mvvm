package com.blimas.data.api

import com.blimas.data.model.CategoryResponse
import com.blimas.network.BaseResponse
import retrofit2.Response
import retrofit2.http.GET

interface MealApi {
    @GET("categories.php")
    suspend fun getCategories(): Response<BaseResponse<CategoryResponse>>
}
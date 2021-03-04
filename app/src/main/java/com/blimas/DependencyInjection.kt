package com.blimas

import com.blimas.data.MealRepository
import com.blimas.data.MealRepositoryImpl
import com.blimas.data.api.MealApi
import com.blimas.domain.GetCategories
import com.blimas.domain.GetCategoriesUseCase
import com.blimas.network.Service
import com.blimas.presenter.MealViewModel
import org.koin.dsl.module

val mealServiceModule = module {

    single { Service().createService(MealApi::class.java) }

    single<MealRepository> { MealRepositoryImpl(get()) }

    single<GetCategoriesUseCase> { GetCategories(get()) }

    single { MealViewModel(get()) }
}
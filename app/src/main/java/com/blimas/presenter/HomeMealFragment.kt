package com.blimas.presenter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.blimas.meals.databinding.FragmentHomeMealBinding
import com.blimas.presenter.adapter.CategoriesAdapter
import com.blimas.presenter.model.CategoryUiModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class HomeMealFragment : Fragment() {

    private val viewModel: MealViewModel by sharedViewModel()

    private lateinit var binding: FragmentHomeMealBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeMealBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.categories.observe( viewLifecycleOwner, Observer { listCategoryUiModel ->
            populateMealsCategory(listCategoryUiModel)
        })

        viewModel.getCategories()
    }

    private fun populateMealsCategory(categories: List<CategoryUiModel>) {
        binding.rvMeals.adapter = CategoriesAdapter(categories)
    }
}
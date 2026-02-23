package com.example.shoppinglist.domain.usecase

import com.example.shoppinglist.domain.model.Category
import com.example.shoppinglist.domain.model.ShoppingItem
import com.example.shoppinglist.domain.repository.ShoppingRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AddItemUseCase @Inject constructor(
private val repository: ShoppingRepository
) {
    suspend operator fun invoke(name: String, category: Category) {
        repository.addItem(
            ShoppingItem(
                name = name,
                category = category
            )
        )
    }
}
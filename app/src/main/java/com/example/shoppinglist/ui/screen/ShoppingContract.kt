package com.example.shoppinglist.ui.screen

import com.example.shoppinglist.domain.model.Category
import com.example.shoppinglist.domain.model.ShoppingItem

sealed class ShoppingIntent {
    data class AddItem(val name: String, val category: Category) : ShoppingIntent()
    data class DeleteItem(val item: ShoppingItem) : ShoppingIntent()
    data class ToggleItem(val item: ShoppingItem) : ShoppingIntent()
    data class FilterByCategory(val category: Category?) : ShoppingIntent()
}

data class ShoppingState(
    val items: List<ShoppingItem> = emptyList(),
    val filteredCategory: Category? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
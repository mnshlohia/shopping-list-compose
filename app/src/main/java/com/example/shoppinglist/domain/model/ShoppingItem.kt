package com.example.shoppinglist.domain.model

data class ShoppingItem(
    val id: Long = 0,
    val name: String,
    val category: Category,
    val isCompleted: Boolean = false
)

enum class Category {
    MILK,
    VEGETABLES,
    FRUITS,
    BREADS,
    MEATS
}
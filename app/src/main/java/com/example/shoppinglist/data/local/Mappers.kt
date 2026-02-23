package com.example.shoppinglist.data.local

import com.example.shoppinglist.domain.model.Category
import com.example.shoppinglist.domain.model.ShoppingItem

fun ShoppingItemEntity.toDomain() = ShoppingItem(
    id = id,
    name = name,
    category = Category.valueOf(category),
    isCompleted = isCompleted
)

fun ShoppingItem.toEntity() = ShoppingItemEntity(
    id = id,
    name = name,
    category = category.name,
    isCompleted = isCompleted
)
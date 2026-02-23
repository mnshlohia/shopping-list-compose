package com.example.shoppinglist.domain.repository

import com.example.shoppinglist.domain.model.ShoppingItem
import kotlinx.coroutines.flow.Flow

interface ShoppingRepository {
    fun getItems(): Flow<List<ShoppingItem>>
    suspend fun addItem(item: ShoppingItem)
    suspend fun deleteItem(item: ShoppingItem)
    suspend fun updateItem(item: ShoppingItem)
}
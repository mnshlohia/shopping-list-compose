package com.example.shoppinglist.data.repository

import com.example.shoppinglist.data.local.ShoppingItemDao
import com.example.shoppinglist.data.local.toDomain
import com.example.shoppinglist.data.local.toEntity
import com.example.shoppinglist.domain.model.ShoppingItem
import com.example.shoppinglist.domain.repository.ShoppingRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ShoppingRepositoryImpl @Inject constructor(
    private val dao: ShoppingItemDao
) : ShoppingRepository {

    override fun getItems(): Flow<List<ShoppingItem>> {
        return dao.getAllItems()
            .map { entities ->
                entities.map { it.toDomain() }
            }
    }

    override suspend fun addItem(item: ShoppingItem) {
        dao.insertItem(item.toEntity())
    }

    override suspend fun deleteItem(item: ShoppingItem) {
        dao.deleteItem(item.toEntity())
    }

    override suspend fun updateItem(item: ShoppingItem) {
        dao.updateItem(item.toEntity())
    }
}
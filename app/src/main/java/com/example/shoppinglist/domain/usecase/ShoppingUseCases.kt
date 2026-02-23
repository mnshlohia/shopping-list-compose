package com.example.shoppinglist.domain.usecase

data class ShoppingUseCases(
    val getItems: GetItemsUseCase,
    val addItem: AddItemUseCase,
    val deleteItem: DeleteItemUseCase,
    val updateItem: UpdateItemUseCase
)
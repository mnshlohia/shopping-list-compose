package com.example.shoppinglist.di

import com.example.shoppinglist.domain.usecase.AddItemUseCase
import com.example.shoppinglist.domain.usecase.DeleteItemUseCase
import com.example.shoppinglist.domain.usecase.GetItemsUseCase
import com.example.shoppinglist.domain.usecase.ShoppingUseCases
import com.example.shoppinglist.domain.usecase.UpdateItemUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    fun provideShoppingUseCases(
        getItems: GetItemsUseCase,
        addItem: AddItemUseCase,
        deleteItem: DeleteItemUseCase,
        updateItem: UpdateItemUseCase
    ): ShoppingUseCases {
        return ShoppingUseCases(
            getItems,
            addItem,
            deleteItem,
            updateItem
        )
    }
}
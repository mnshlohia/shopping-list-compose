package com.example.shoppinglist.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoppinglist.domain.usecase.ShoppingUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShoppingViewModel @Inject constructor(
    private val useCases: ShoppingUseCases
) : ViewModel() {

    private val _state = MutableStateFlow(ShoppingState())
    val state: StateFlow<ShoppingState> = _state.asStateFlow()

    init {
        observeItems()
    }

    private fun observeItems() {
        viewModelScope.launch {
            useCases.getItems()
                .collect { items ->
                    reduce {
                        copy(items = items)
                    }
                }
        }
    }

    fun onIntent(intent: ShoppingIntent) {
        when (intent) {
            is ShoppingIntent.AddItem -> {
                viewModelScope.launch {
                    useCases.addItem(intent.name, intent.category)
                }
            }

            is ShoppingIntent.DeleteItem -> {
                viewModelScope.launch {
                    useCases.deleteItem(intent.item)
                }
            }

            is ShoppingIntent.ToggleItem -> {
                viewModelScope.launch {
                    useCases.updateItem(
                        intent.item.copy(
                            isCompleted = !intent.item.isCompleted
                        )
                    )
                }
            }

            is ShoppingIntent.FilterByCategory -> {
                reduce {
                    copy(filteredCategory = intent.category)
                }
            }
        }
    }

    private fun reduce(update: ShoppingState.() -> ShoppingState) {
        _state.update { it.update() }
    }
}
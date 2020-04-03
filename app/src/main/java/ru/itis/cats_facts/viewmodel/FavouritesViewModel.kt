package ru.itis.cats_facts.viewmodel

import androidx.lifecycle.ViewModel
import ru.itis.cats_facts.data.repository.CatFactRepository
import javax.inject.Inject

class FavouritesViewModel @Inject constructor(val repository: CatFactRepository) : ViewModel() {
}

package ru.itis.cats_facts.di.modules

import androidx.lifecycle.ViewModel
import dagger.Module
import dagger.Provides
import ru.itis.cats_facts.data.repository.CatFactRepository
import ru.itis.cats_facts.data.repository.CatFactRepositoryImpl
import dagger.Binds

import dagger.multibindings.IntoMap
import ru.itis.cats_facts.di.ScreenScope
import ru.itis.cats_facts.di.ViewModelKey
import ru.itis.cats_facts.viewmodel.FavouritesViewModel

@Module(includes = [ViewModelModule::class])
interface FavouritesModule {

    @Binds
    @IntoMap
    @ViewModelKey(FavouritesViewModel::class)
    fun bindFavouritesViewModel(
        favouritesViewModel: FavouritesViewModel
    ): ViewModel
}

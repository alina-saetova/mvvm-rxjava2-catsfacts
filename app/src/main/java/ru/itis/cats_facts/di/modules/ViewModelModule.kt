package ru.itis.cats_facts.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.itis.cats_facts.di.ScreenScope
import ru.itis.cats_facts.di.ViewModelKey
import ru.itis.cats_facts.viewmodel.*

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(
        factory: AppViewModelFactory
    ): ViewModelProvider.Factory
}

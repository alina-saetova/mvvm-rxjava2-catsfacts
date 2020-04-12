package ru.itis.cats_facts.di.modules

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.itis.cats_facts.di.ViewModelKey
import ru.itis.cats_facts.viewmodel.DetailsViewModel

@Module(includes = [ViewModelModule::class])
interface DetailsModule {

    @Binds
    @IntoMap
    @ViewModelKey(DetailsViewModel::class)
    abstract fun bindDetailsViewModel(
        detailsViewModel: DetailsViewModel
    ): ViewModel
}

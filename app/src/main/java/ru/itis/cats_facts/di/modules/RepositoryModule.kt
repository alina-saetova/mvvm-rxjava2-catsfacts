package ru.itis.cats_facts.di.modules

import dagger.Binds
import dagger.Module
import ru.itis.cats_facts.data.repository.CatFactRepository
import ru.itis.cats_facts.data.repository.CatFactRepositoryImpl
import javax.inject.Singleton

@Module
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindCatFactRepository(catFactRepositoryImpl: CatFactRepositoryImpl): CatFactRepository
}

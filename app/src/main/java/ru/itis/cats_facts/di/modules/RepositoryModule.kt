package ru.itis.cats_facts.di.modules

import dagger.Module
import dagger.Provides
import ru.itis.cats_facts.data.local.dao.CatItemDao
import ru.itis.cats_facts.data.remote.service.CatFactsService
import ru.itis.cats_facts.data.remote.service.CatPictureService
import ru.itis.cats_facts.data.repository.CatFactRepositoryImpl
import javax.inject.Singleton

@Module(includes = [NetModule::class, LocalDataModule::class])
class RepositoryModule {

    @Provides
    @Singleton
    fun provideCatFactRepository(apiPictures: CatPictureService,
                                 apiFacts: CatFactsService,
                                  dao: CatItemDao):
            CatFactRepositoryImpl = CatFactRepositoryImpl(apiPictures, apiFacts, dao)
}

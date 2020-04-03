package ru.itis.cats_facts.di.modules

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ru.itis.cats_facts.data.local.AppDatabase
import ru.itis.cats_facts.data.local.dao.CatItemDao
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Provides
    @Singleton
    fun provideDb(app: Application): AppDatabase {
        return Room.databaseBuilder(
                app,
                AppDatabase::class.java, "sample1.db")
            .build()
    }

    @Provides
    @Singleton
    fun provideCatItemDao(db: AppDatabase): CatItemDao = db.catItemDao()
}

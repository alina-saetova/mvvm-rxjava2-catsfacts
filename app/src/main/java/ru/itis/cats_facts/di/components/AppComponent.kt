package ru.itis.cats_facts.di.components

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import ru.itis.cats_facts.di.App
import ru.itis.cats_facts.di.modules.*
import javax.inject.Singleton

@Singleton
@Component(modules = [
    NetModule::class,
    LocalDataModule::class,
    RepositoryModule::class,
    RemoteSourceModule::class,
    AndroidInjectionModule::class,
    MainActivityModule::class,
    ViewModelModule::class
])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(application: App)
}

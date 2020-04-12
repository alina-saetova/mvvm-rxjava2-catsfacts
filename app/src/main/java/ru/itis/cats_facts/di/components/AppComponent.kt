package ru.itis.cats_facts.di.components

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import ru.itis.cats_facts.MainActivity
import ru.itis.cats_facts.di.App
import ru.itis.cats_facts.di.modules.*
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    LocalDataModule::class,
    NetModule::class,
    RepositoryModule::class
])
interface AppComponent {

    fun favouritesComponentBuilder(): FavouritesComponent.Factory
    fun detailsComponentBuilder(): DetailsComponent.Factory

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    fun inject(app: App)
    fun inject(mainActivity: MainActivity)
}

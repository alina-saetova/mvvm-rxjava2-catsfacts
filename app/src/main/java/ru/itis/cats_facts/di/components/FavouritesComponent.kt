package ru.itis.cats_facts.di.components

import dagger.Subcomponent
import ru.itis.cats_facts.di.ScreenScope
import ru.itis.cats_facts.di.modules.FavouritesModule
import ru.itis.cats_facts.view.FavouritesFragment

@ScreenScope
@Subcomponent(modules = [FavouritesModule::class])
interface FavouritesComponent {

    @Subcomponent.Factory
    interface Factory {
        fun build(): FavouritesComponent
    }

    fun inject(fragment: FavouritesFragment)
}

package ru.itis.cats_facts.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.itis.cats_facts.view.FavouritesFragment
import ru.itis.cats_facts.view.CategoriesFragment

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeFavouritesFragment(): FavouritesFragment

    @ContributesAndroidInjector
    abstract fun contributeCategoriesFragment(): CategoriesFragment
}

package ru.itis.cats_facts.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.itis.cats_facts.DetailsActivity
import ru.itis.cats_facts.MainActivity

@Suppress("unused")
@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun contributeDetailsActivity(): DetailsActivity
}

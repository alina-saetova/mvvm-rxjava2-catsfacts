package ru.itis.cats_facts.di.components

import dagger.Subcomponent
import ru.itis.cats_facts.DetailsActivity
import ru.itis.cats_facts.di.ScreenScope
import ru.itis.cats_facts.di.modules.DetailsModule

@ScreenScope
@Subcomponent(modules = [DetailsModule::class])
interface DetailsComponent {

    @Subcomponent.Factory
    interface Factory {
        fun build(): DetailsComponent
    }

    fun inject(activity: DetailsActivity)
}

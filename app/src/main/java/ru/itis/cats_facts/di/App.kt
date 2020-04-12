package ru.itis.cats_facts.di

import android.app.Application
import ru.itis.cats_facts.di.components.AppComponent
import ru.itis.cats_facts.di.components.DaggerAppComponent

class App: Application() {

    companion object {
        lateinit var component: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder()
            .application(this)
            .build()

        component.inject(this)
    }
}

package ru.itis.cats_facts.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.itis.cats_facts.data.local.dao.CatItemDao
import ru.itis.cats_facts.data.model.CatItem

@Database(entities = [CatItem::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun catItemDao(): CatItemDao
}

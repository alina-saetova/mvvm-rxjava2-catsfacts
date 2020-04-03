package ru.itis.cats_facts.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import ru.itis.cats_facts.data.model.CatItem

@Dao
interface CatItemDao {

    @Insert
    fun insert(catItem: CatItem)

    @Delete
    fun delete(catItem: CatItem)

    @Query("SELECT * from catItems")
    fun getAll(): List<CatItem>
}

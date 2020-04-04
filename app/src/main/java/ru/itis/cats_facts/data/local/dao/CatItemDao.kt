package ru.itis.cats_facts.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Single
import ru.itis.cats_facts.data.model.CatItem

@Dao
interface CatItemDao {

    @Insert
    fun insert(catItem: CatItem): Completable

    @Delete
    fun delete(catItem: CatItem): Completable

    @Query("SELECT * from catItems")
    fun getAll(): Single<List<CatItem>>
}

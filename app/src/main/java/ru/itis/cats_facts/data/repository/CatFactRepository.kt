package ru.itis.cats_facts.data.repository

import io.reactivex.Completable
import io.reactivex.Single
import ru.itis.cats_facts.data.model.CatItem

interface CatFactRepository {

    fun getFavourites(): Single<List<CatItem>>

    fun getCatFacts(category_id: Int): Single<List<CatItem>>

    fun saveCatItem(catItem: CatItem): Completable

    fun deleteFavourite(catItem: CatItem): Completable
}

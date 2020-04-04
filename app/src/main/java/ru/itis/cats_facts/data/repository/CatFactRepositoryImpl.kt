package ru.itis.cats_facts.data.repository

import android.util.Log
import io.reactivex.Completable
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers
import ru.itis.cats_facts.data.local.dao.CatItemDao
import ru.itis.cats_facts.data.model.CatItem
import ru.itis.cats_facts.data.model.FactsResponse
import ru.itis.cats_facts.data.model.PictureResponseItem
import ru.itis.cats_facts.data.remote.service.CatFactsService
import ru.itis.cats_facts.data.remote.service.CatPictureService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CatFactRepositoryImpl @Inject constructor(
    private var apiPictures: CatPictureService,
    private var apiFacts: CatFactsService,
    private var dao: CatItemDao
) : CatFactRepository {

    override fun getFavourites(): Single<List<CatItem>> {
        return dao.getAll()
    }

    override fun getCatFacts(category_id: Int): Single<List<CatItem>> {
        return Single.zip(
            apiFacts.getFacts(),
            apiPictures.getRandomPictures(category_id.toString()),
            BiFunction { facts, pictures -> fromResponseToModel(pictures, facts) }
        )
    }

    override fun saveCatItem(catItem: CatItem): Completable {
        return dao.insert(catItem)
    }

    override fun deleteFavourite(catItem: CatItem): Completable {
        return dao.delete(catItem)
    }

    private fun fromResponseToModel(
        pictures: List<PictureResponseItem>,
        facts: FactsResponse
    ): List<CatItem> {
        val catItems = mutableListOf<CatItem>()
        val randomFacts = facts.items.shuffled().take(30).toMutableList()
        for (pic in pictures) {
            catItems.add(CatItem(
                0,
                randomFacts.removeAt(0).text,
                pic.id,
                pic.url
            ))
        }
        return catItems
    }
}

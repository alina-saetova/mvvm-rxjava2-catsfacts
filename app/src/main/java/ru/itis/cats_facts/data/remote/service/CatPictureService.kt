package ru.itis.cats_facts.data.remote.service

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import ru.itis.cats_facts.data.model.PictureResponseItem

interface CatPictureService {

    @GET("images/search")
    fun getRandomPictures(@Query("category_ids") id: String) : Single<List<PictureResponseItem>>
}


package ru.itis.cats_facts.data.remote.service

import io.reactivex.Single
import retrofit2.http.GET
import ru.itis.cats_facts.data.model.FactsResponse

interface CatFactsService {

    @GET("facts")
    fun getFacts() : Single<FactsResponse>
}

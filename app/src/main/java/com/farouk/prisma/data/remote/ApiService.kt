package com.farouk.prisma.data.remote

import com.farouk.prisma.data.entities.api.Article
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {

    @GET
    fun getAllArticle(@Url url: String?): Single<Article>


}
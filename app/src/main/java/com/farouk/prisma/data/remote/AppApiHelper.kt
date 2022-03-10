package com.farouk.prisma.data.remote

import android.content.Context
import com.farouk.prisma.data.entities.api.Article
import javax.inject.Inject


class AppApiHelper @Inject constructor(
    private val apiService: ApiService,
    private val context: Context
) : ApiHelper {
    override val getArticlesApi: Article?
        get() = try {
            var url="https://gist.githubusercontent.com/julienbanse/34cdfbd1c094b2dddffce2b5d5533d6b/raw/15b5f322838e08bf8a38985b7aa94f6c758d6741/news.json/"
             apiService.getAllArticle(url).blockingGet()
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }


}


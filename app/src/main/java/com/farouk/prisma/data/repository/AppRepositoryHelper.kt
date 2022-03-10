package com.farouk.prisma.data.repository

import com.farouk.prisma.data.db.DbHelper
import com.farouk.prisma.data.entities.api.Article
import com.farouk.prisma.data.entities.db.ArticleDB
import com.farouk.prisma.data.remote.ApiHelper
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class AppRepositoryHelper @Inject constructor(
    private val mDbHelper: DbHelper,
    private val mApiHelper: ApiHelper,
) : RepositoryHelper {

    override fun saveAllArticles(article: List<ArticleDB>) {
        mDbHelper.saveAllArticles(article)
    }

    override fun saveArticle(article: ArticleDB) {
        mDbHelper.saveArticle(article)
    }

    override fun getAllArticles(): Flow<List<ArticleDB>> {
            return mDbHelper.getAllArticles()
    }

    override fun deleteArticleById(articleId: String) {
        mDbHelper.deleteArticleById(articleId)
    }

    override fun deleteAllArticles() {
        mDbHelper.deleteAllArticles()
    }

    override val getArticlesApi: Article?
        get() = mApiHelper.getArticlesApi


}
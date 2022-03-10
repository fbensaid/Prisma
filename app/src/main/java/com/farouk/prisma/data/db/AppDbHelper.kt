package com.farouk.prisma.data.db

import android.content.Context
import com.farouk.prisma.data.db.dao.ArticleDao
import com.farouk.prisma.data.entities.db.ArticleDB
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow

import javax.inject.Inject

class AppDbHelper @Inject constructor(
    @ApplicationContext private val context: Context,
    private val articleDao: ArticleDao
) : DbHelper {

    override fun saveAllArticles(article: List<ArticleDB>) {
        articleDao.saveAllArticle(article)

    }

    override fun saveArticle(article:ArticleDB) {
        articleDao.saveArticle(article)
    }

    override fun getAllArticles(): Flow<List<ArticleDB>> {
       return articleDao.getAllArticle()
    }

    override fun deleteArticleById(id: String) {
        articleDao.deleteArticleById(id)
    }

    override fun deleteAllArticles() {
        articleDao.deleteAll()
    }

}
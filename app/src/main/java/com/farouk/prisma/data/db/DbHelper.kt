package com.farouk.prisma.data.db

import com.farouk.prisma.data.entities.api.Article
import com.farouk.prisma.data.entities.db.ArticleDB
import kotlinx.coroutines.flow.Flow

interface DbHelper {

    // Article
    fun saveAllArticles(article: List<ArticleDB>)
    fun saveArticle(article:ArticleDB)
    fun getAllArticles(): Flow<List<ArticleDB>>
    fun deleteArticleById(idArticle: String)
    fun deleteAllArticles()

}
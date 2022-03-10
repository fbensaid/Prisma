package com.farouk.prisma.data.db.dao

import androidx.room.*
import com.farouk.prisma.data.entities.db.ArticleDB
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllArticle(colisEvent: List<ArticleDB>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveArticle(article: ArticleDB)

    @Query("SELECT * FROM article")
    fun getAllArticle(): Flow<List<ArticleDB>>

    @Delete
    fun delete(article: ArticleDB)

    @Query("DELETE FROM article WHERE idArticle = :idArticle")
    fun deleteArticleById(idArticle: String)

    @Query("Delete FROM article")
    fun deleteAll()

}
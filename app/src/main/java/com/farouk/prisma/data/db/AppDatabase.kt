package com.farouk.prisma.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.farouk.prisma.data.db.dao.ArticleDao
import com.farouk.prisma.data.entities.api.Article
import com.farouk.prisma.data.entities.db.ArticleDB

@Database(
    entities = [
        ArticleDB::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        var databaseName = "PRISMA"
    }

    abstract fun articleDao(): ArticleDao


}
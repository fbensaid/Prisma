package com.farouk.prisma.data.di

import android.content.Context
import androidx.room.Room
import com.farouk.prisma.data.db.AppDatabase
import com.farouk.prisma.data.db.dao.ArticleDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
internal object AppModule {

    @Provides
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java, AppDatabase.databaseName
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideArticle(appDatabase: AppDatabase): ArticleDao {
        return appDatabase.articleDao()
    }

}

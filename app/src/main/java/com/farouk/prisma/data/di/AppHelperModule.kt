package com.farouk.prisma.data.di

import android.content.Context
import com.farouk.prisma.data.db.AppDatabase
import com.farouk.prisma.data.db.AppDbHelper
import com.farouk.prisma.data.remote.ApiService
import com.farouk.prisma.data.remote.AppApiHelper
import com.farouk.prisma.data.repository.AppRepositoryHelper
import com.farouk.prisma.data.repository.RepositoryHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object AppHelperModule {

    @Provides
    @Singleton
    fun provideAppDbHelper(@ApplicationContext appContext: Context, appDatabase: AppDatabase) =
        AppDbHelper(
            appContext,
            appDatabase.articleDao(),
        )


    @Provides
    @Singleton
    fun provideAppApiHelper(
        apiService: ApiService,
        @ApplicationContext context: Context) =
        AppApiHelper( apiService, context)

    @Provides
    @Singleton
    fun provideRepositoryHelper(
        dbHelper: AppDbHelper,
        apiHelper: AppApiHelper
    ) = AppRepositoryHelper(
        dbHelper,
        apiHelper,
    ) as RepositoryHelper


}

package com.farouk.prisma.view.viewmodel

import android.content.ClipData
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.farouk.prisma.data.entities.api.Article
import com.farouk.prisma.data.entities.api.Items
import com.farouk.prisma.data.entities.db.ArticleDB
import com.farouk.prisma.data.repository.RepositoryHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val mRepository: RepositoryHelper
) : ViewModel() {

    private var articleLiveData = MutableLiveData<Article>()
    var articleDBLiveData = MutableLiveData<List<ArticleDB>>()

    fun getArticleLiveData(): LiveData<Article> {
        return articleLiveData
    }

    fun getArticleDBLiveData(): LiveData<List<ArticleDB>> {
        return articleDBLiveData
    }

    // fetch root menu list
    fun getArticlesFromApi() {
        viewModelScope.launch(Dispatchers.IO) {
            var article = mRepository.getArticlesApi
            articleLiveData.postValue(article)
        }
    }

    // fetch root menu list
    fun saveArticleToDb(articleDB: ArticleDB) {
        viewModelScope.launch(Dispatchers.IO) {
            mRepository.saveArticle(articleDB)
        }
    }

    // fetch root menu list
    fun deleteArticleFromDB(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            mRepository.deleteArticleById(id)
        }
    }

    // fetch root menu list
    fun getArticlesFromDb() {
        viewModelScope.launch(Dispatchers.IO) {
            mRepository
                .getAllArticles().collect {
                    articleDBLiveData.postValue(it)
                }
        }
    }
}
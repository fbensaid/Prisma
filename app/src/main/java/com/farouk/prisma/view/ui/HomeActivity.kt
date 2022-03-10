package com.farouk.prisma.view.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.fragment.NavHostFragment
import com.farouk.prisma.R
import com.farouk.prisma.databinding.ActivityHomeBinding
import com.farouk.prisma.view.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async

@AndroidEntryPoint
class HomeActivity : AppCompatActivity(){

    private var _viewBinding: ActivityHomeBinding? = null
    private val binding get() = _viewBinding!!

    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController

    private lateinit var viewModel: HomeViewModel

    private val parentJob = Job()
    private val viewScope = CoroutineScope(Dispatchers.IO + parentJob)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        _viewBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        // check Article list from Api
        viewScope.async { viewModel.getArticlesFromApi() }
        viewScope.async { viewModel.getArticlesFromDb() }


        binding.bottomNavigation.setOnNavigationItemReselectedListener { item ->
            when(item.itemId) {
                R.id.item1 -> {
                    navigateToDbFragment()
                }
                R.id.item2 -> {
                    navigateToHomeFragment()
                }
            }
        }
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    navigateToDbFragment()
                }
                R.id.favorite -> {
                    navigateToHomeFragment()
                }
            }
            true
        }

    }
    private fun navigateToHomeFragment(){
        val navDirections: NavDirections =
            ArticleApiFragmentDirections.actionArticleApiFragmentToArticleDbFragment()
        navController.navigate(navDirections)
    }
    private fun navigateToDbFragment(){
        val navDirections: NavDirections =
            ArticleDbFragmentDirections.actionArticleDbFragmentToArticleApiFragment()
        navController.navigate(navDirections)
    }


    companion object {
        private val TAG = HomeActivity::class.java.name
    }

}
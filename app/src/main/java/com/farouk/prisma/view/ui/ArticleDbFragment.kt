package com.farouk.prisma.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.farouk.prisma.databinding.FragmentArticleApiBinding
import com.farouk.prisma.view.adapter.ArticlesDBAdapter
import com.farouk.prisma.view.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArticleDbFragment : Fragment() {

    private var _fragmentHomeViewBinding: FragmentArticleApiBinding? = null
    private val binding get() = _fragmentHomeViewBinding!!

    private val viewModel: HomeViewModel by activityViewModels()
    private var articlesAdapter: ArticlesDBAdapter? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _fragmentHomeViewBinding = FragmentArticleApiBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        displayArticleDb()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _fragmentHomeViewBinding = null
    }

    private fun displayArticleDb() {
        viewModel.getArticleDBLiveData().observe(viewLifecycleOwner, {
            if (it!=null){
                binding.rvMenus.layoutManager = LinearLayoutManager(this.context)
                articlesAdapter = ArticlesDBAdapter(it!!,requireContext())
                binding.rvMenus.adapter = articlesAdapter
                onMenuClickItem()
            }
        })
    }
    private fun onMenuClickItem() {
        articlesAdapter!!.onItemMenuClick = { article ->
                viewModel.deleteArticleFromDB(article.idArticle!!)

        }
    }
}
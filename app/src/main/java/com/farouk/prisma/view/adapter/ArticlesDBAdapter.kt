package com.farouk.prisma.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.farouk.prisma.R
import com.farouk.prisma.data.entities.api.Article
import com.farouk.prisma.data.entities.api.Items
import com.farouk.prisma.data.entities.db.ArticleDB
import com.farouk.prisma.databinding.RecycleviewArticleBinding

class ArticlesDBAdapter(
    private val listOfArticle: List<ArticleDB>,val context: Context
) : RecyclerView.Adapter<ArticlesDBAdapter.ArticleViewHolder>() {

    var onItemMenuClick: ((ArticleDB) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val binding = RecycleviewArticleBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleViewHolder(binding)
    }

    override fun getItemCount() = listOfArticle.size

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val articleImages = listOfArticle[position]
        Glide.with(context).load(R.drawable.ic_heart_clicked).into(holder.binding.favorite)

        if (articleImages.url != null) {
            Glide.with(context)
                .load(articleImages.url)
                .into(holder.binding.image)
            holder.binding.imgName.text=articleImages.copyright
            holder.binding.menuCardItem.visibility=View.VISIBLE
        }else{
            holder.binding.menuCardItem.visibility=View.GONE
        }

        holder.binding.menuCardItem.setOnClickListener {
            onItemMenuClick?.invoke(listOfArticle[position])
        }
    }

    inner class ArticleViewHolder( val binding: RecycleviewArticleBinding) :
        RecyclerView.ViewHolder(binding.root)

}
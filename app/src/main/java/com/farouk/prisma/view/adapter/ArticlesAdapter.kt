package com.farouk.prisma.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.farouk.prisma.R
import com.farouk.prisma.data.entities.api.Article
import com.farouk.prisma.data.entities.db.ArticleDB
import com.farouk.prisma.databinding.RecycleviewArticleBinding
import java.util.*

class ArticlesAdapter(
    private val listOfArticle: Article,
    private val listOfArticleDB: List<ArticleDB>,
    val context: Context
) : RecyclerView.Adapter<ArticlesAdapter.ArticleViewHolder>() {

    var onItemMenuClick: ((ArticleDB, Boolean) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val binding = RecycleviewArticleBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleViewHolder(binding)
    }

    override fun getItemCount() = listOfArticle.data.items.size

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val articleImages = listOfArticle.data.items[position]

        var urlImage = ""
        var articleName = ""
        if (articleImages.medias.imageCount > 0) {
            urlImage = articleImages.medias.images[0].original.url
            articleName = articleImages.medias.images[0].copyright
        } else {
            urlImage =
                "https://www.prismamedia.com/wp-content/uploads/2021/04/Prisma-Media-e1621326673111.png"
            articleName = articleImages.title
        }

        Glide.with(context).load(urlImage).into(holder.binding.image)
        holder.binding.imgName.text = articleName

        var articleDB = checkArticleInDb(articleName)

        saveLikeState(articleDB, holder.binding.favorite)


        holder.binding.menuCardItem.setOnClickListener {
            if (articleDB != null) {
                onItemMenuClick?.invoke(articleDB, true)
                Glide.with(context).load(R.drawable.ic_heart_unclick).into(holder.binding.favorite)
            } else {
                onItemMenuClick?.invoke(
                    ArticleDB(articleName, urlImage, Date().toString(), articleImages.resource.id),
                    false
                )
                Glide.with(context).load(R.drawable.ic_heart_clicked).into(holder.binding.favorite)
            }
        }
    }

    private fun saveLikeState(articleDB: ArticleDB?, view: ImageView) {
        if (articleDB != null)
            Glide.with(context).load(R.drawable.ic_heart_clicked).into(view)
        else
            Glide.with(context).load(R.drawable.ic_heart_unclick).into(view)
    }

    private fun checkArticleInDb(title: String): ArticleDB? {
        return listOfArticleDB.firstOrNull { event ->
            event.copyright!!.contains(title)
        }
    }

    inner class ArticleViewHolder(val binding: RecycleviewArticleBinding) :
        RecyclerView.ViewHolder(binding.root)

}
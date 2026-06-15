package com.example.news_app.presentation.list

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.news_app.R
import com.example.news_app.domain.entities.Article

class NewListAdapter: ListAdapter<Article, NewListAdapter.ArticleViewHolder>(DiffUtillCallback()) {
    inner class ArticleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(article: Article){
            val newsParentView = itemView.findViewById<ConstraintLayout>( R.id.cl_news_parent)
            val newsImageView = itemView.findViewById<ImageView>(R.id.iv_news_image)
            val newsDateView = itemView.findViewById<TextView>(R.id.tv_news_date)
            val newsTitleView = itemView.findViewById<TextView>(R.id.tv_news_title)
            val newsDescription = itemView.findViewById<TextView>(R.id.tv_news_description)

            Glide.with(itemView)
                .load(article.urlToImage)
                .into(newsImageView)
            newsDateView.text = article.publishedAt
            newsTitleView.text = article.title
            newsDescription.text = article.description
        }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NewListAdapter.ArticleViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: NewListAdapter.ArticleViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}
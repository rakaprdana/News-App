package com.example.news_app.presentation.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.news_app.MyApplication
import com.example.news_app.R
import com.example.news_app.domain.entities.Article

private const val KEY_NEWS_CATEGORY = "category"

class ListFragment : Fragment(), NewsListEventListener{
    private var newsCategory: String? = null
    private lateinit var newsListViewModel: NewsListViewModel

    private val newsListAdapter = NewListAdapter(this)
    private lateinit var rvNewsList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val appContainer = (requireActivity().application as MyApplication).appContainer
        newsListViewModel = ViewModelProvider(this, appContainer.viewModelFactory)
            .get(NewsListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        iniList()
        observeNewsList()
        newsListViewModel.fetchTopHeadline(newsCategory ?: "business")
    }

    private fun observeNewsList(){
        newsListViewModel.newList.observe(viewLifecycleOwner){ news->
            newsListAdapter.submitList(news.articles)
        }
    }

    fun iniList(){
        view?.let {
            rvNewsList = it.findViewById(R.id.rv_news_list)
            rvNewsList.adapter = newsListAdapter
            rvNewsList.layoutManager = LinearLayoutManager(context)
        }
    }

    override fun onItemClicked(article: Article) {
        val bundle = bundleOf("Article" to article)
        findNavController().navigate(R.id.action_homeFragment_to_detailFragment, bundle)
    }

    companion object {
        @JvmStatic
        fun newInstance(category: String) =
            ListFragment().apply {
                arguments = Bundle().apply {
                    putString(KEY_NEWS_CATEGORY, category)
                }
            }
    }
}
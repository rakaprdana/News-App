package com.example.news_app.presentation.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.news_app.presentation.list.ListFragment

class ViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    val categoryList =
        listOf("Business", "Entertainment", "General", "Health", "Science", "Sports", "Technology")

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun createFragment(position: Int): Fragment {
        return ListFragment.newInstance(category = categoryList[position])
    }

}
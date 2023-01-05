package com.example.newsaggregator.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.newsaggregator.GeneralSettings
import com.example.newsaggregator.SourceSettings
import com.example.newsaggregator.TopicSelect

class TabAdapter (activity: AppCompatActivity) : FragmentStateAdapter(activity){

    override fun createFragment(index:Int): Fragment{
        when (index) {
            0 -> return GeneralSettings()
            1 -> return SourceSettings()
            2 -> return TopicSelect()
        }
        return GeneralSettings()
    }

    override fun getItemCount(): Int{
        return 3
    }
}

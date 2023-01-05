package com.example.newsaggregator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

/*todo
See if you can get toolbar working in feed

need some general settings like disabling alerts

need alerts??

Alternative sources???

type up
*/

class TopicSelect : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var testView = inflater.inflate(R.layout.fragment_topics, container, false)
        val recyclerView = testView.findViewById<View>(R.id.topic_recycler_view) as RecyclerView
        val topicList = populateTopicList()
        val numberOfColumns = 2
        val layoutManager = GridLayoutManager(activity, numberOfColumns)

        recyclerView.layoutManager = layoutManager
        val mAdapter = TopicAdapter(topicList)
        recyclerView.adapter = mAdapter

        return testView
    }

    private fun populateTopicList(): ArrayList<TopicModel>{
        val list = ArrayList<TopicModel>()
        val topicAdaption = resources.getStringArray(R.array.topics)

        for(i in 0..19){
            val topicsModel = TopicModel()
            topicsModel.setTopics(topicAdaption[i].toString())
            list.add(topicsModel)
        }
    return list
    }

}

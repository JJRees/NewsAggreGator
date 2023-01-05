package com.example.newsaggregator

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TopicAdapter (private val topicArrayList: MutableList<TopicModel>) : RecyclerView.Adapter<TopicAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val myView = inflater.inflate(R.layout.topic_settings, parent, false)
        return ViewHolder(myView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val info = topicArrayList[position]

        holder.topics.text = info.getTopics() //?
    }

    override fun getItemCount(): Int {
        return topicArrayList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{
        val topics = itemView.findViewById<View>(R.id.topic_placeholder) as TextView
        init{
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View){
            //Enable/disable topic
        }
    }


}
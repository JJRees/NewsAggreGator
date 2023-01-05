package com.example.newsaggregator

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SourceAdapter (private val sourceArrayList: MutableList<SourceModel>): RecyclerView.Adapter<SourceAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        val inflater = LayoutInflater.from(parent.context)
        val myView = inflater.inflate(R.layout.source_settings, parent, false)
        return ViewHolder(myView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val info = sourceArrayList[position]

        holder.logos.setImageResource(info.getLogos())
        holder.sources.text = info.getCompanies()
    }

    override fun getItemCount(): Int {
        return sourceArrayList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{
        val sources = itemView.findViewById<View>(R.id.source_name) as TextView
        val logos = itemView.findViewById<View>(R.id.logo) as ImageView
        init{
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            //Something later
        }
    }
}
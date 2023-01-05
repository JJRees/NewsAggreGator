package com.example.newsaggregator

import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import org.w3c.dom.Text

class FeedAdapter (private val newsFeedArrayList: MutableList<FeedModel>) : RecyclerView.Adapter<FeedAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val myView = inflater.inflate(R.layout.feed_row, parent, false)
        return ViewHolder(myView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        val info = newsFeedArrayList[position]

        holder.thumb.setImageResource(info.getThumbnails())
        holder.headline.text = info.getHeadlines()
        holder.summary.text = info.getSummaries()
        holder.storySource.text = info.getSourceName()
        holder.tags.text = info.getTags()
        holder.urls.text = info.getURL()
    //        holder.ratings.rating = info.getSourceRating()
    }

    override fun getItemCount(): Int {
        return newsFeedArrayList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{
        val thumb = itemView.findViewById<View>(R.id.thumbnail) as ImageView
        val headline = itemView.findViewById<View>(R.id.headline) as TextView
        val summary = itemView.findViewById<View>(R.id.summary) as TextView
        val storySource = itemView.findViewById<View>(R.id.source_feed) as TextView
        val tags = itemView.findViewById<View>(R.id.tags) as TextView
        val urls = itemView.findViewById<View>(R.id.url) as TextView
//        val ratings = itemView.findViewById<View>(R.id.ratingBar) as RatingBar
        init{
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            //Open Article in browser (Implicit)
            try {
                val articleIntent: Intent = Uri.parse(urls.text.toString()).let {
                    webpage -> Intent(Intent.ACTION_VIEW, webpage)
                }
                startActivity(v.context, articleIntent, null)
                val snackbar = Snackbar.make(v, "Testing", Snackbar.LENGTH_LONG)
                snackbar.show()
            } catch (e: java.lang.Exception){
                Log.i("Activities", "NullInput")
            }

        }
    }

}
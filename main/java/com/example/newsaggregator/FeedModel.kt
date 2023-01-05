package com.example.newsaggregator

import android.media.Rating

class FeedModel {
    var headline: String? = null
    var summary: String? = null
    var tag: String? = null
    var nameOfSource: String? = null
    var url: String? = null
//    var ratings: Float = 0F
    var thumbnail: Int = 0

    fun getHeadlines(): String {
        return headline.toString()
    }
    fun setHeadlines(title: String){
        this.headline = title
    }
    fun getSummaries(): String{
        return summary.toString()
    }
    fun setSummaries(blurb: String){
        this.summary = blurb
    }
    fun getTags(): String{
        return tag.toString()
    }
    fun setTags(topic: String) {
        this.tag = topic
    }
    fun getSourceName(): String{
        return nameOfSource.toString()
    }
    fun setSourceName(news: String){
        this.nameOfSource = news
    }
//    fun getSourceRating(): Float{
//        return ratings
//    }
//    fun setSourceRating(sourceRating: Float){
//        this.ratings = sourceRating
//    }
    fun getThumbnails(): Int {
        return thumbnail
    }
    fun setThumbnails(image_drawable: Int){
        this.thumbnail = image_drawable
    }

    fun getURL(): String{
        return url.toString()
    }

    fun setURL(url: String){
        this.url = url
    }
}
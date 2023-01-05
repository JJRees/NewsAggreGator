package com.example.newsaggregator

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import androidx.viewpager2.widget.ViewPager2
import com.example.newsaggregator.adapter.TabAdapter
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.koushikdutta.ion.Ion
import org.json.JSONArray
import org.json.JSONObject

class Feed : AppCompatActivity() {

    private val newsCatcher = "https://api.newscatcherapi.com/v2/search?q=Football&lang=en&countries=GB"

    val headlines = ArrayList<String>()
    val summaries = ArrayList<String>()
    val topics = ArrayList<String>()
    val sources = ArrayList<String>()
    val urls = ArrayList<String>()
    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feed_activity)

        val demoArrayList = populateDemoList()

        val recyclerView = findViewById<View>(R.id.feed_recycler_view) as RecyclerView
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        val mAdapter = FeedAdapter(demoArrayList)
        recyclerView.adapter = mAdapter
        //val extras = intent.extras

        val mToolbar = findViewById<Toolbar>(R.id.feed_toolbar)
        setSupportActionBar(mToolbar)
    }

    private fun refreshFeed(){
        val newsArrayList = populateDemoList()

        val recyclerView = findViewById<View>(R.id.feed_recycler_view) as RecyclerView
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        val mAdapter = FeedAdapter(newsArrayList)
        recyclerView.adapter = mAdapter
    }

    private fun populateDemoList(): ArrayList<FeedModel> {
        val list = ArrayList<FeedModel>()

        getJSON()

        for (i in 0 until counter){
            val imageModel = FeedModel()
            imageModel.setHeadlines(headlines[i])
            imageModel.setSummaries(summaries[i])
            imageModel.setTags(topics[i])
//            imageModel.setThumbnails(myThumbnailList[i])
            imageModel.setSourceName(sources[i])
//            imageModel.setSourceRating(demoRatings[i])
            imageModel.setURL(urls[i])
            list.add(imageModel)
        }
        return list
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate((R.menu.toolbar_layout), menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val myView = findViewById<View>(R.id.feed_toolbar)
        when (item.itemId){
            R.id.log_out_button -> {
                val snackbar = Snackbar.make(myView, "You pushed logoff", Snackbar.LENGTH_LONG)
                snackbar.show()
                return true
            }
            R.id.refresh_button -> {
                refreshFeed()
                val snackbar = Snackbar.make(myView, "Feed Refreshed", Snackbar.LENGTH_LONG)
                snackbar.show()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    //New stuff with API
    private fun getJSON (){
        Ion.with(this)
            .load(newsCatcher)
            .setHeader("x-api-key", "jr4K2zKiVyukAvlhVartpA44DjMNSAq9o10B1HYvEXM")
            .asString()
            .setCallback{_, result ->
                loadNews(result)
            }
    }

    private fun loadNews (newsData: String){
        val myJSON = JSONObject(newsData)
        val articlesArray = myJSON.getJSONArray("articles")
        loadTitles(articlesArray, headlines)
        loadDescriptions(articlesArray, summaries)
        loadTopics(articlesArray, topics)
        loadSources(articlesArray, sources)
        loadURLS(articlesArray, urls)
    }

    private fun loadTitles(news: JSONArray, headlines: ArrayList<String>){
        for (i in 0 until news.length()){
            val myJSON = JSONObject(news.getString(i))
            val articleTitle = myJSON.getString("title")
            headlines.add(articleTitle)
            counter += 1
        }
    }

    private fun loadDescriptions(news: JSONArray, summaries: ArrayList<String>){
        for (i in 0 until news.length()){
            val myJSON = JSONObject(news.getString(i))
            val articleSummary = myJSON.getString("summary")
            summaries.add(articleSummary)
        }
    }

    private fun loadTopics(news: JSONArray, topics: ArrayList<String>){
        for (i in 0 until news.length()){
            val myJSON = JSONObject(news.getString(i))
            val articleTopic = myJSON.getString("topic")
            topics.add(articleTopic)
        }
    }

    private fun loadSources(news: JSONArray, sources: ArrayList<String>){
        for (i in 0 until news.length()){
            val myJSON = JSONObject(news.getString(i))
            val articleSource = myJSON.getString("clean_url")
            sources.add(articleSource)
        }
    }

    private fun loadURLS(news: JSONArray, urls: ArrayList<String>){
        for (i in 0 until news.length()){
            val myJSON = JSONObject(news.getString(i))
            val articleURL = myJSON.getString("link")
            urls.add(articleURL)
        }
    }
}
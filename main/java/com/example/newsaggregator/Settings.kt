package com.example.newsaggregator

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.newsaggregator.adapter.TabAdapter
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class Settings : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings_main)

        val mToolbar = findViewById<Toolbar>(R.id.settings_toolbar)
        setSupportActionBar(mToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
        val viewPager = findViewById<ViewPager2>(R.id.view_pager2)

        val tabTitles = resources.getStringArray(R.array.tab_titles)

        viewPager.adapter = TabAdapter(this)
        TabLayoutMediator(tabLayout, viewPager) {tab,position ->
            when (position){
                0 -> tab.text = tabTitles[0]
                1 -> tab.text = tabTitles[1]
                2 -> tab.text = tabTitles[2]
            }
        }.attach()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate((R.menu.toolbar_layout), menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val myView = findViewById<View>(R.id.settings_toolbar)
        when (item.itemId){
            R.id.log_out_button -> {
                val snackbar = Snackbar.make(myView, "You pushed logoff", Snackbar.LENGTH_LONG)
                snackbar.show()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}
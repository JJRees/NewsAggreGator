package com.example.newsaggregator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class SourceSettings : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var testView = inflater.inflate(R.layout.fragment_sources, container, false)
        val recyclerView = testView.findViewById<View>(R.id.source_recycler_view) as RecyclerView
        val demoSourceList = populateSourceList()
        val layoutManager = LinearLayoutManager(activity)
        recyclerView.layoutManager = layoutManager
        val mAdapter = SourceAdapter(demoSourceList)
        recyclerView.adapter = mAdapter

        return testView
    }

    private fun populateSourceList(): ArrayList<SourceModel>{
        val list = ArrayList<SourceModel>()
//        val sourceAdaption = resources.getStringArray(R.array.sources)
//
//        val myLogos = arrayOf(R.drawable.bbc, R.drawable.bloomberg, R.drawable.cnn, R.drawable.ft,
//            R.drawable.guardian, R.drawable.independent, R.drawable.mail, R.drawable.nytimes,
//            R.drawable.telegraph, R.drawable.times)
//        val sourceList = arrayOf(sourceAdaption[0], sourceAdaption[6], sourceAdaption[5],
//            sourceAdaption[8], sourceAdaption[1], sourceAdaption[2], sourceAdaption[4],
//            sourceAdaption[7], sourceAdaption[3], sourceAdaption[9])
//
//        for(i in 0 .. 9){
//            val imageModel = SourceModel()
//            imageModel.setCompanies(sourceList[i].toString())
//            imageModel.setLogos(myLogos[i])
//            list.add(imageModel)
//        }
        return list
    }
}
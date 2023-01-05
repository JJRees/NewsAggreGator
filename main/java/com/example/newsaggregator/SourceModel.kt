package com.example.newsaggregator

class SourceModel {
    var company: String? = null
    var logo: Int = 0

    fun getCompanies(): String{
        return company.toString()
    }
    fun setCompanies(name: String){
        this.company = name
    }

    fun getLogos(): Int {
        return logo
    }
    fun setLogos(image_drawable: Int){
        this.logo = image_drawable
    }
}
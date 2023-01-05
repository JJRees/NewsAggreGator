package com.example.newsaggregator

class TopicModel {
    var topic: String? = null

    fun getTopics(): String {
        return topic.toString()
    }

    fun setTopics(subject: String) {
        this.topic = subject
    }
}
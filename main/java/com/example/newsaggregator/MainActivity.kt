package com.example.newsaggregator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

//API Key - 77e9bb025d734b948a01f979ea9407f4

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Temporarily making the button always work
        val loginButton = findViewById<Button>(R.id.login)
        loginButton.setOnClickListener{v -> launchFeed(v)}

        //Temporarily making register button go to settings
        val registerButton = findViewById<Button>(R.id.register)
        registerButton.setOnClickListener{v -> launchRegister(v)}


    }

    fun launchFeed(view: View) {
        val newIntent = Intent(this, Feed::class.java)
        startActivity(newIntent)
    }

    fun launchRegister(view: View) {
        val newIntent = Intent(this, Settings::class.java)
        startActivity(newIntent)
    }
}
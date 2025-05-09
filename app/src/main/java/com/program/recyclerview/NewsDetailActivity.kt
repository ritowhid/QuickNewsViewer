package com.program.recyclerview

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class NewsDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)

        val heading = intent.getStringExtra("heading")
        val newsContent = intent.getStringExtra("newsContent")
        val imageId = intent.getIntExtra("imageId", R.drawable.pic1)

        val headingTV = findViewById<TextView>(R.id.newsHeading)
        val headingIV = findViewById<ImageView>(R.id.newsImage)
        val newsContentTV = findViewById<TextView>(R.id.newsContent)

        headingTV.text = heading
        newsContentTV.text = newsContent
        headingIV.setImageResource(imageId)
    }
}
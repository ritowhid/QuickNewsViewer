package com.program.quicknews

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.program.quicknews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var myRecyclerView: RecyclerView
    private lateinit var newsArrayList: ArrayList<News>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        myRecyclerView = binding.recyclerView
        myRecyclerView.layoutManager = LinearLayoutManager(this)

        val newsImageArray = arrayOf(
            R.drawable.pic1,
            R.drawable.pic2,
            R.drawable.pic3,
            R.drawable.pic4,
            R.drawable.pic5
        )

        val newsHeadingArray = arrayOf(
            "Apple unveils iPhone 16 series: Standard model starting at $799, Pro version from $999",
            "Microsoft, Meta CEOs defend hefty AI spending after DeepSeek stuns tech world",
            "ChatGPT or DeepSeek: Which one should you use?",
            "Launching POCO X7 with amazing features, competing with budget-friendly mobiles",
            "BITFEST looking for campus ambassadors, stay tuned for updates"
        )

        val newsContentArray = arrayOf(
            getString(R.string.news_content),
            getString(R.string.news_content),
            getString(R.string.news_content),
            getString(R.string.news_content),
            getString(R.string.news_content)
        )

        // to set behavior of items inside recyclerview, vertically scrolling, horizontally, uniform grid
        newsArrayList = arrayListOf<News>()

        for (index in newsImageArray.indices) {
            val news = News(newsHeadingArray[index], newsImageArray[index], newsContentArray[index])
            newsArrayList.add(news)
        }

        var myAdapter = MyAdapter(newsArrayList, this)
        myRecyclerView.adapter = myAdapter
        myAdapter.setOnItemClickListener(object : MyAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                val intent = Intent(applicationContext, NewsDetailActivity::class.java)
                intent.putExtra("heading", newsArrayList[position].newsHeading)
                intent.putExtra("imageId", newsArrayList[position].newsImage)
                intent.putExtra("newsContent", newsArrayList[position].newsContent)
                startActivity(intent)
            }
        })
    }
}

package com.example.aplicationdetik

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.api.load
import com.example.aplicationdetik.databinding.ActivityDetailBinding
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.cdv_news_headline.*

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    companion object{
        const val date ="date"
        const val content ="content"
        const val image ="image"

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tanggal = intent.getStringExtra(date)
        val content = intent.getStringExtra(content)
        val imageDetail = intent.getStringExtra(image)

        txtDate.text = tanggal
        txtContent.text = content
        img_detail.load(imageDetail)
    }
}
package com.example.aplicationdetik

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aplicationdetik.adapter.RvNewsAdapter
import com.example.aplicationdetik.databinding.ActivityMainBinding
import com.example.aplicationdetik.model.ResponeNews
import com.example.aplicationdetik.service.RetrofitBuilder
import retrofit2.Call
import retrofit2.Response
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val rvAdapter = RvNewsAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.plant(Timber.DebugTree())
        binding =ActivityMainBinding.inflate(layoutInflater)
        with(binding){
            setContentView(root)
//            setSupportActionBar(toolBar)
            mainRv.adapter = rvAdapter
            mainRv.layoutManager = LinearLayoutManager(baseContext)
            mainRv.setHasFixedSize(true)
        }
        val call = RetrofitBuilder.getService().feachHeadlines()
        call.enqueue(object : retrofit2.Callback<ResponeNews>{
            override fun onFailure (call: Call<ResponeNews>, t: Throwable){
                Timber.e(t.localizedMessage)

            }

            override fun onResponse(call: Call<ResponeNews>, response: Response<ResponeNews>) {
                Timber.d(response.body()?.totalResults.toString())
                val listArticlesItem = response.body()?.articles
                listArticlesItem.let {
                    it?.let { it1 -> rvAdapter.addData(it1) }
                }

            }

        })
    }
}
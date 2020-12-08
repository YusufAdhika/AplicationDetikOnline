package com.example.aplicationdetik.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import coil.size.Scale
import com.example.aplicationdetik.DetailActivity
import com.example.aplicationdetik.databinding.CdvNewsHeadlineBinding
import com.example.aplicationdetik.model.ArticlesItem
import kotlinx.android.synthetic.main.cdv_news_headline.view.*

class RvNewsAdapter : RecyclerView.Adapter<CdvNewsHeadline> (){

    private val listNews : ArrayList<ArticlesItem> = arrayListOf()

    fun addData(rpla: List<ArticlesItem>){
        listNews.clear()
        listNews.addAll(rpla)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CdvNewsHeadline {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CdvNewsHeadlineBinding.inflate(layoutInflater, parent, false)
        return CdvNewsHeadline(binding)
    }

    override fun getItemCount(): Int {
        return listNews.size
    }

    override fun onBindViewHolder(holder: CdvNewsHeadline, position: Int) {
        val data = listNews[position]
        holder.bind(data)
        holder.itemView.setOnClickListener{
            val intent = Intent(it.context,DetailActivity::class.java)
            intent.putExtra(DetailActivity.date, data.publishedAt)
            intent.putExtra(DetailActivity.content,data.content)
            intent.putExtra(DetailActivity.image,data.urlToImage)
            it.context.startActivity(intent)
        }
    }
}

class CdvNewsHeadline(private val binding: CdvNewsHeadlineBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(item: ArticlesItem) {
        with(binding){
            txtTitle.text = item.title
            textView3.text = item.description
            imageView.load(item.urlToImage){
                scale(Scale.FILL)
            }
        }
    }
}
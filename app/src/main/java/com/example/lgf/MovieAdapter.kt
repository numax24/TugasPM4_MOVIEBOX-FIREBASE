package com.example.lgf

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.lgf.databinding.ItemBinding

class MovieAdapter (var c:Context, var movieList:ArrayList<ItemData>): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>()
{
    inner class MovieViewHolder(var v :ItemBinding): RecyclerView.ViewHolder(v.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflter = LayoutInflater.from(parent.context)
        val v = DataBindingUtil.inflate<ItemBinding>(inflter,R.layout.item,parent,false)
        return MovieViewHolder(v)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val newList = movieList[position]
        holder.v.isMovie = movieList[position]
        holder.v.root.setOnClickListener {

            val detail = newList.detailbox
            val gambar = newList.gambarbox
            val genre = newList.genrebox
            val nama = newList.namabox
            val rating = newList.ratingbox
            val rilis = newList.rilisbox
            val waktu = newList.waktubox

            val mIntent = Intent(c,Detail::class.java)
            mIntent.putExtra("detail",detail)
            mIntent.putExtra("gambar",gambar)
            mIntent.putExtra("genre",genre)
            mIntent.putExtra("nama",nama)
            mIntent.putExtra("rating",rating)
            mIntent.putExtra("rilis",rilis)
            mIntent.putExtra("waktu",waktu)
            c.startActivity(mIntent)
        }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}

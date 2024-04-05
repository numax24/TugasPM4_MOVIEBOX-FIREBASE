package com.example.lgf

import android.location.GnssAntennaInfo.Listener
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class MovieAdapter (private val namaList : ArrayList<ItemData>):RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {
    private  lateinit var mListener :onItemCLickListener

    interface onItemCLickListener {
        fun onItemClick (position: Int)
    }

    fun setOnItemClickListener(Listener: onItemCLickListener){
        mListener = Listener
    }
    class MyViewHolder (ItemData : View, Listener: onItemCLickListener) : RecyclerView.ViewHolder (ItemData) {
        val gambar : ImageView = ItemData.findViewById(R.id.imageView2)
        val nama   : TextView = ItemData.findViewById(R.id.idMovie)
        val rilis  : TextView = ItemData.findViewById(R.id.idRilis)
        val genre  : TextView = ItemData.findViewById(R.id.idGenre)
        val rating : TextView = ItemData.findViewById(R.id.idRate)

        init {
            itemView.setOnClickListener{
                Listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemData = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return MyViewHolder(itemData, mListener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = namaList[position]
        holder.gambar.setImageResource(currentItem.gambar)
        holder.nama.text   = currentItem.nama
        holder.rilis.text  = currentItem.rilis
        holder.genre.text  = currentItem.genre
        holder.rating.text = currentItem.rating
    }

    override fun getItemCount(): Int = namaList.size
}
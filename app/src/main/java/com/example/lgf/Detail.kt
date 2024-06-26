package com.example.lgf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import kotlinx.android.synthetic.main.activity_detail.*
import android.widget.ImageView
import android.widget.TextView
import com.example.lgf.databinding.ActivityDetailBinding

class Detail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val movIntent = intent
        val movDetail = movIntent.getStringExtra("detail")
        val movGambar = movIntent.getStringExtra("gambar")
        val movGenre = movIntent.getStringExtra("genre")
        val movNama = movIntent.getStringExtra("nama")
        val movRating = movIntent.getStringExtra("rating")
        val movRilis = movIntent.getStringExtra("rilis")
        val movWaktu = movIntent.getStringExtra("waktu")

        tvDeskripsi.text = movDetail
        tvGenre.text = movGenre
        tvTitle.text = movNama
        tvRate.text = movRating
        tvDate.text = movRilis
        tvTime.text = movWaktu
        tvImage.loadImage(movGambar, getProgessDrawble(this))

    }
}
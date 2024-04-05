package com.example.lgf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import kotlinx.android.synthetic.main.activity_detail.*
import android.widget.ImageView
import android.widget.TextView

class Detail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val gambar : ImageView = findViewById(R.id.tvImage)
        val nama  : TextView = findViewById(R.id.tvTitle)
        val rilis  : TextView = findViewById(R.id.tvDate)
        val genre  : TextView = findViewById(R.id.tvGenre)
        val rating  : TextView = findViewById(R.id.tvRate)
        val waktu  : TextView = findViewById(R.id.tvTime)
        val informasi  : TextView = findViewById(R.id.tvDeskripsi)

        val bundle : Bundle? = intent.extras
        val bNama = bundle!!.getString("idnama")
        val bGambar = bundle.getInt("idgambar")
        val bRilis = bundle.getString("idrilis")
        val bGenre = bundle.getString("idgenre")
        val bRating = bundle.getString("idrating")
        val bWaktu = bundle.getString("idwaktu")
        val bInformasi = bundle.getString("idinformasi")

        gambar.setImageResource(bGambar)
        nama.text = bNama
        rilis.text = bRilis
        genre.text = bGenre
        rating.text = bRating
        waktu.text = bWaktu
        informasi.text = bInformasi

        btnBack.setOnClickListener(View.OnClickListener {startActivity(Intent(this, Home::class.java)) })
    }
}
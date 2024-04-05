package com.example.lgf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.app.Activity
import android.content.ClipData.Item
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_home.*

class Home : AppCompatActivity() {
    private lateinit var movieRecyclerView: RecyclerView
    private lateinit var gambar     : Array<Int>
    private lateinit var nama       : Array<String>
    private lateinit var rilis      : Array<String>
    private lateinit var genre      : Array<String>
    private lateinit var rating     : Array<String>
    private lateinit var waktu      : Array<String>
    private lateinit var informasi  : Array<String>
    private  lateinit var ListMovie : ArrayList<ItemData>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        gambar = arrayOf(
            R.drawable.bullettrain,
            R.drawable.deadpool,
            R.drawable.dune,
            R.drawable.forrestgump,
            R.drawable.freeguy,
            R.drawable.oppenheimer,
            R.drawable.theadamproject,
            R.drawable.thebatman,
            R.drawable.theconjuring,
            R.drawable.thehangover
        )

        nama = arrayOf(
            "Bullet Train",
            "Deadpool 2",
            "Dune Part I",
            "Forrest Gump",
            "Free Guy",
            "Oppenheimer",
            "The Adam Project",
            "The Batman",
            "The Conjuring",
            "The Hangover"
        )

        rilis = arrayOf(
            "10-Agustus-2022",
            "15-Mei-2018",
            "13-Oktober-2021",
            "06-Juli-1994",
            "13-Agustus-2021",
            "19-Juli-2023",
            "09-Maret-2022",
            "04-Maret-2022",
            "19-Juli-2013",
            "05-Juni-2009"
        )

        genre = arrayOf(
            "Action,Comedy,Thriller",
            "Action,Adventure,Comedy",
            "Action,Adventure,Drama",
            "Drama,Romance",
            "Action,Adventure,Comedy",
            "Biography,Drama,Histroy",
            "Action,Adventure,Comedy",
            "Action,Crime,Drama",
            "Horror,Mystery,Thriller",
            "Comedy"
        )

        rating = arrayOf(
            "7.3",
            "7.6",
            "8.0",
            "8.8",
            "7.1",
            "8.3",
            "6.7",
            "7.8",
            "7.5",
            "7.7"
        )

        waktu = arrayOf(
            "2h 7m",
            "1h 59m",
            "2h 35m",
            "2h 22m",
            "1h 55m",
            "3h",
            "1h 46m",
            "2h 56m",
            "1h 52m",
            "1h 40m"
        )

        informasi = arrayOf(
            getString(R.string.bullet_train),
            getString(R.string.deadpool2),
            getString(R.string.dune1),
            getString(R.string.forrest_gump),
            getString(R.string.free_guy),
            getString(R.string.oppenheimer),
            getString(R.string.the_adam_project),
            getString(R.string.the_batman),
            getString(R.string.the_conjuring),
            getString(R.string.the_hangover)
        )

        movieRecyclerView = findViewById(R.id.movieRV)
        movieRecyclerView.layoutManager = LinearLayoutManager(this)
        movieRecyclerView.setHasFixedSize(true)

        ListMovie = arrayListOf<ItemData>()
        getDataUser()
    }
    private fun getDataUser() {
        for (i in gambar.indices){
            val dataMovie = ItemData(gambar[i],nama[i],rilis[i],genre[i],rating[i],waktu[i])
            ListMovie.add(dataMovie)
        }
        var adapter = MovieAdapter(ListMovie)
        movieRecyclerView.adapter = adapter
        adapter.setOnItemClickListener(object: MovieAdapter.onItemCLickListener{
            override fun onItemClick(position: Int) {
                intent = Intent(this@Home, Detail::class.java)
                intent.putExtra("idgambar",ListMovie[position].gambar)
                intent.putExtra("idnama",ListMovie[position].nama)
                intent.putExtra("idrilis",ListMovie[position].rilis)
                intent.putExtra("idgenre",ListMovie[position].genre)
                intent.putExtra("idrating",ListMovie[position].rating)
                intent.putExtra("idwaktu",ListMovie[position].waktu)
                intent.putExtra("idinformasi",informasi[position])
                startActivity(intent)
            }
        })
    }
}
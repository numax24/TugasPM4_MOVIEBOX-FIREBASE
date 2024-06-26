package com.example.lgf

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lgf.databinding.ActivityHomeBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_home.*

class Home : AppCompatActivity() {
    lateinit var mDataBase : DatabaseReference
    private lateinit var movieList : ArrayList<ItemData>
    private lateinit var mAdapter : MovieAdapter
    private lateinit var binding :ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        movieList = ArrayList()
        mAdapter = MovieAdapter(this,movieList)
        binding.progressBar.visibility = View.VISIBLE
        movieRV.layoutManager = LinearLayoutManager(this)
        movieRV.setHasFixedSize(true)
        movieRV.adapter = mAdapter
        getMovieData()

        val imageBack: ImageView = findViewById(R.id.imageBack)
        imageBack.setOnClickListener {
            logout()
        }
    }

    private fun getMovieData() {
        FirebaseApp.initializeApp(this)
        mDataBase = FirebaseDatabase.getInstance().getReference("moviebox")
        mDataBase.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (movieSnapshot in snapshot.children) {
                        val movie = movieSnapshot.getValue(ItemData::class.java)
                        movieList.add(movie!!)
                    }
                    mAdapter.notifyDataSetChanged()
                    binding.progressBar.visibility = View.GONE
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@Home,error.message,Toast.LENGTH_SHORT).show()
                binding.progressBar.visibility = View.INVISIBLE
            }

        })
    }
    private fun logout() {
        FirebaseAuth.getInstance().signOut()
        Toast.makeText(this, "Logged out successfully", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        finish()
    }

}
package com.example.lgf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textForgot.setOnClickListener(View.OnClickListener {startActivity(Intent(this, Forget::class.java)) })
        textRegister.setOnClickListener(View.OnClickListener {startActivity(Intent(this, Register::class.java)) })
        btnLogin.setOnClickListener(View.OnClickListener {startActivity(Intent(this, Home::class.java)) })
    }
}
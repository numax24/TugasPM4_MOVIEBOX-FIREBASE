package com.example.lgf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.util.Patterns
import android.widget.Toast
import com.example.lgf.databinding.ActivityForgetBinding
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_forget.*


class Forget : AppCompatActivity() {
    private lateinit var binding : ActivityForgetBinding
    private lateinit var Auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        binding.btnReset.setOnClickListener {
            val email : String = binding.forgetEmail.text.toString()
            val editemail = binding.forgetEmail
            if (email.isEmpty()) {
                forgetEmail.error = "Input Email"
                forgetEmail.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                forgetEmail.error = "Invalid Email"
                forgetEmail.requestFocus()
                return@setOnClickListener
            }

            FirebaseAuth.getInstance().sendPasswordResetEmail(email).addOnCompleteListener {
                if (it.isSuccessful) {
                    Toast.makeText(this, "Check Email for Reset Password", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                else {
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
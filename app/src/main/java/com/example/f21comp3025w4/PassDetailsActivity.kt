package com.example.f21comp3025w4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.f21comp3025w4.databinding.ActivityPassDetailsBinding

class PassDetailsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityPassDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPassDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //configure the back button to return to the main activity
        binding.backButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        //read from the intent and display the name on the activity
        binding.welcomeTextView.text = "Welcome " + intent.getStringExtra("personName")

    }
}
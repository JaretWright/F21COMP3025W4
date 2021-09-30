package com.example.f21comp3025w4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.f21comp3025w4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //configrue a variable to access the view binding
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.passInfobutton.setOnClickListener {
            var copiedText = binding.nameEditText.text.toString()
            if (copiedText.isNotEmpty())
            {
                var intent = Intent(this, PassDetailsActivity::class.java)
                intent.putExtra("personName",copiedText)
                startActivity(intent)
            }
            else
            {
                Toast.makeText(this, "Enter your name at the top", Toast.LENGTH_LONG).show()
            }
        }
    }
}
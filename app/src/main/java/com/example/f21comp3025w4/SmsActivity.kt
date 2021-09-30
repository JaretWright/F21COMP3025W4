package com.example.f21comp3025w4

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.f21comp3025w4.databinding.ActivitySmsBinding

class SmsActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySmsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySmsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backToMainButton.setOnClickListener {
            finish()
        }

        binding.smsButton.setOnClickListener {
            var phoneNumber = binding.phoneEditText.text.toString()
            var message = binding.messageEditText.text.toString()

            if (phoneNumber.isNotEmpty() && message.isNotEmpty())
            {
                val uri = Uri.parse("smsto:$phoneNumber")
                val intent = Intent(Intent.ACTION_SENDTO, uri)
                intent.putExtra("sms_body", message)
                startActivity(intent)
            }
            else
            {
                Toast.makeText(this, "Phone # and message are both required", Toast.LENGTH_LONG).show()
            }
        }
    }
}
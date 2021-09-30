package com.example.f21comp3025w4

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.f21comp3025w4.databinding.ActivityWebBrowserBinding

class WebBrowserActivity : AppCompatActivity() {

    //configure the binding to access the objects in the layout
    private lateinit var binding : ActivityWebBrowserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebBrowserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //configure the back to main button to return to the main activity
        binding.backToMainButton.setOnClickListener {
            finish()
        }

        //create an IMPLICIT intent to web services
        binding.loadUrlButton.setOnClickListener {
            if (binding.urlEditText.text.toString().isNullOrBlank())
            {
                Toast.makeText(this, "Add a URL", Toast.LENGTH_LONG).show()
            }
            else
            {
                var url = binding.urlEditText.text.toString()

                //check to make sure that it starts with https://
                if (!(url.startsWith("http://") || url.startsWith("https://")))
                    url = "http://" + url

                //create an implicit intent
                val intent = Intent(Intent.ACTION_VIEW)

                //add data to the intent
                intent.data = Uri.parse(url)

                //launch the intent
                startActivity(intent)
            }
        }
    }
}
package com.example.andersen_hw1

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.bumptech.glide.Glide

class MainActivity : ComponentActivity() {
    private var downloadButton: Button? = null
    private val imageUrl = "https://upweek.ru/wp-content/uploads/2000/01/download-software-0.jpg"
    private val picture: ImageView by lazy { findViewById(R.id.picture) }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        downloadButton = findViewById(R.id.download)

        downloadButton?.setOnClickListener {
            if(it.isPressed) {
                picture.loadImageFromUrl(imageUrl)

            }
        }

    }

    fun ImageView.loadImageFromUrl(url: String) {
        Glide.with(this.context).load(url).into(this)
    }
}
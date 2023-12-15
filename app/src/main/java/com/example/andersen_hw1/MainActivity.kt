package com.example.andersen_hw1

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.andersen_hw1.databinding.ActivityMainBinding
import com.example.andersen_hw1.retrofit.ProductApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val inteceptor = HttpLoggingInterceptor()
        inteceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder().addInterceptor(inteceptor).build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://dummyjson.com")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val productApi = retrofit.create(ProductApi::class.java)

        binding.mainBtn.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val currentProduct = productApi.getProductById(3)
                runOnUiThread {
                    binding.result.text = currentProduct.title
                }
            }
        }
    }
}
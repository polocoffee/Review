package com.banklannister.review

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.banklannister.review.adapter.CoffeeAdapter
import com.banklannister.review.databinding.ActivityMainBinding
import com.banklannister.review.model.Coffee
import com.banklannister.review.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupService()

    }

    private fun setupService() {
        val apiService = ApiService.coffeeService()
        apiService.getCoffee().enqueue(object : Callback<List<Coffee>> {
            override fun onResponse(call: Call<List<Coffee>>, response: Response<List<Coffee>>) {
                if (response.isSuccessful) {
                    val items = response.body()
                    items?.let {
                        val adapter = CoffeeAdapter(items)
                        binding.rvMain.layoutManager = LinearLayoutManager(this@MainActivity)
                        binding.rvMain.adapter = adapter
                    }
                }
            }

            override fun onFailure(call: Call<List<Coffee>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Error Server", Toast.LENGTH_LONG).show()
            }

        })
    }
}
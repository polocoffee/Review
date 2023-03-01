package com.banklannister.review.network

import com.banklannister.review.Constants.END_POINT
import com.banklannister.review.model.Coffee
import retrofit2.Call
import retrofit2.http.GET

interface CoffeeInterface {

    @GET(END_POINT)
    fun getCoffee(): Call<List<Coffee>>
}
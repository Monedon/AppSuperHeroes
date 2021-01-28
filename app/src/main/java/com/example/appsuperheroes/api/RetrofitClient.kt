package com.example.appsuperheroes.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitClient {
    companion object {
        private const val BASE_URL = "https://akabab.github.io/superhero-api/api/"

        fun retrofitCliente(): Api {
            val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
                GsonConverterFactory.create()
            ).build()

            return retrofit.create(Api::class.java)
        }
    }
}
package com.example.appsuperheroes.api

import com.example.appsuperheroes.model.Heroes
import retrofit2.Response
import retrofit2.http.GET

interface Api {

        @GET("all.json")
        suspend fun getHeros(): Response<List<Heroes>>

    }
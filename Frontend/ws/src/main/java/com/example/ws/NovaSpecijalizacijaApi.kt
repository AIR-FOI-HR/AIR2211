package com.example.ws

import com.example.core.entities.Specijalizacija
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface NovaSpecijalizacijaApi {
    @POST("/ednevnik-0.0.1-SNAPSHOT/specijalizacija/add")
    fun dodajSpecijlizaciju (@Body specijalizacija: Specijalizacija) : Call<Specijalizacija>
}
package com.example.ws

import com.example.core.entities.Pitanje
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface DodajPitanjeApi {
    @POST("/ednevnik-0.0.1-SNAPSHOT/pitanja/add")
    fun dodajPitanje (@Body pitanje: Pitanje) : Call<Pitanje>
}
package com.example.ws

import com.example.core.entities.Pitanje
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UrediPitanjeApi {
    @POST("/ednevnik-0.0.1-SNAPSHOT/pitanja/update")
    fun urediPitanje (@Body pitanje: Pitanje) : Call<Pitanje>
}
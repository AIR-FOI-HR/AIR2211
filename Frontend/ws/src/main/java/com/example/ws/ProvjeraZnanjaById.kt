package com.example.ws

import com.example.core.entities.ProvjeraZnanja
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ProvjeraZnanjaById {
    @GET("/ednevnik-0.0.1-SNAPSHOT/provjere_znanja/getById/{id}")
    fun getProvjeraZnanja(@Path("id") provjeraZnanjaId : Int) : Call<ProvjeraZnanja>
}
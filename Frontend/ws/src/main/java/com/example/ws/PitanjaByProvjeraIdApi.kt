package com.example.ws

import com.example.core.entities.Pitanje
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PitanjaByProvjeraIdApi {
    @GET("/ednevnik-0.0.1-SNAPSHOT/pitanja/getAllByProvjeraId/{id}")
    fun getPitanja(@Path("id") provjeraId : Int) : Call<ArrayList<Pitanje>>
}
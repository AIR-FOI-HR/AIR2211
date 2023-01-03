package com.example.ws

import com.example.core.entities.Specijalizant
import retrofit2.Call
import retrofit2.http.GET

interface SpecijalizantiApi {
    @GET("/ednevnik-0.0.1-SNAPSHOT/specijalizanti/get")
    fun getSpecijalizantData() : Call<ArrayList<Specijalizant>>
}
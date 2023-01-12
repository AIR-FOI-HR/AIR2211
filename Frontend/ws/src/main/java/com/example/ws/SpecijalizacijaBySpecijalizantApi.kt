package com.example.ws

import com.example.core.entities.Specijalizacija
import com.example.core.entities.Specijalizant
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface SpecijalizacijaBySpecijalizantApi {
    @GET("/ednevnik-0.0.1-SNAPSHOT/specijalizacija/getActiveBySpecijalizantId/{id}")
    fun getSpecijalizacijaData(@Path("id") specijalizantId : Int) : Call<Specijalizacija>
}
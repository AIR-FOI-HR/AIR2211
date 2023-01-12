package com.example.ws

import com.example.core.entities.SlucajBolesnika
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface SlucajBolesnikaByIdApi {
    @GET("/ednevnik-0.0.1-SNAPSHOT/slucajevi_bolesnika/getById/{id}")
    fun getSlucajBolesnika(@Path("id") slucajBolesnikaId : Int) : Call<SlucajBolesnika>
}
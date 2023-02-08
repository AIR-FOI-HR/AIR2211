package com.example.ws

import com.example.core.entities.SlucajBolesnika
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface SlucajeviBolesnikaBySpecijalizacijaIdApi {
    @GET("/ednevnik-0.0.1-SNAPSHOT/slucajevi_bolesnika/getAllBySpecijalizacijaId/{id}")
    fun getSlucajeviBolesnika(@Path("id") specijalizacijaId : Int) : Call<ArrayList<SlucajBolesnika>>
}
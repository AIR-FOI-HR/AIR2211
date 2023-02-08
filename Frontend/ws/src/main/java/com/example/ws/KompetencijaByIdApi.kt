package com.example.ws

import com.example.core.entities.Kompetencija
import com.example.core.entities.SlucajBolesnika
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface KompetencijaByIdApi {
    @GET("/ednevnik-0.0.1-SNAPSHOT/kompetencije/getById/{id}")
    fun getKompetencija(@Path("id") kompetencijaId : Int) : Call<Kompetencija>
}
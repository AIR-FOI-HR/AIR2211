package com.example.ws

import com.example.core.entities.Mentor
import com.example.core.entities.Specijalizacija
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface SpecijalizacijaByIdApi {
    @GET("/ednevnik-0.0.1-SNAPSHOT/specijalizacija/getById/{id}")
    fun getSpecijalizacijaById(@Path("id") specijalizacijaId : Int) : Call<Specijalizacija>
}
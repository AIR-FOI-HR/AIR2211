package com.example.ws

import com.example.core.entities.Ispit
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface NadolazeciIspitiBySpecijalizacijaApi {
    @GET("/ednevnik-0.0.1-SNAPSHOT/ispiti/getUpcomingBySpecijalizacijaId/{id}")
    fun getIspiti(@Path("id") specijalizacijaId : Int) : Call<ArrayList<Ispit>>
}
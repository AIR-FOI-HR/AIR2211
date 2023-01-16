package com.example.ws

import com.example.core.entities.ProvjeraZnanja
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ProvjereZnanjaBySpecijalizacijaIdApi {
    @GET("/ednevnik-0.0.1-SNAPSHOT/provjere_znanja/getAllBySpecijalizacijaId/{id}")
    fun getProvjereZnanja(@Path("id") specijalizacijaId : Int) : Call<ArrayList<ProvjeraZnanja>>
}
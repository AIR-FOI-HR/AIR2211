package com.example.ws

import com.example.core.entities.Ispit
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface IspitiBySpecijalizacijaIdApi {
    @GET("/ednevnik-0.0.1-SNAPSHOT/ispiti/getAllBySpecijalizacijaId/{id}")
    fun getIspiti(@Path("id") specijalizacijaId : Int) : Call<ArrayList<Ispit>>
}
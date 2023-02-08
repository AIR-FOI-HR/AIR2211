package com.example.ws

import com.example.core.entities.DnevnaAktivnost
import com.example.core.entities.Kompetencija
import com.example.core.entities.Zahvat
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ZahvatiByProgramSpecijalizacijeApi {
    @GET("/ednevnik-0.0.1-SNAPSHOT/zahvati/getAllByProgramSpecijalizacijeId/{id}")
    fun getZahvati(@Path("id") programSpecijalizacijeId : Int) : Call<ArrayList<Zahvat>>
}
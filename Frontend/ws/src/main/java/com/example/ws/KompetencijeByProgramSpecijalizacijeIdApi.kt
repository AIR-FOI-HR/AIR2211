package com.example.ws

import com.example.core.entities.DnevnaAktivnost
import com.example.core.entities.Kompetencija
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface KompetencijeByProgramSpecijalizacijeIdApi {
    @GET("/ednevnik-0.0.1-SNAPSHOT/kompetencije/getAllByProgramSpecijalizacijeId/{id}")
    fun getKompetencije(@Path("id") programSpecijalizacijeId : Int) : Call<ArrayList<Kompetencija>>
}
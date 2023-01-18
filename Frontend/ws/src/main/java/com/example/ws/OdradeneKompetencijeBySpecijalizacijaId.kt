package com.example.ws

import com.example.core.entities.DnevnaAktivnost
import com.example.core.entities.OdradenaKompetencija
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface OdradeneKompetencijeBySpecijalizacijaId {
    @GET("/ednevnik-0.0.1-SNAPSHOT/odradene_kompetencije/getAllBySpecijalizacija/{id}")
    fun getOdradeneKompetencijie(@Path("id") specijalizacijaId : Int) : Call<ArrayList<OdradenaKompetencija>>
}
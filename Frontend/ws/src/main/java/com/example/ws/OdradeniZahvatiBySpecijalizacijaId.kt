package com.example.ws

import com.example.core.entities.OdradenaKompetencija
import com.example.core.entities.OdradeniZahvat
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface OdradeniZahvatiBySpecijalizacijaId {
    @GET("/ednevnik-0.0.1-SNAPSHOT/odradeni_zahvati/getAllBySpecijalizacija/{id}")
    fun getOdradeniZahvati(@Path("id") specijalizacijaId : Int) : Call<ArrayList<OdradeniZahvat>>
}
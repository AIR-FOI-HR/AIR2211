package com.example.ws

import com.example.core.entities.OdradenaKompetencija
import com.example.core.entities.OdradeniDioSpecijalizacije
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface OdradeniDijeloviSpecijalizacijeBySpecijalizacijaId {
    @GET("/ednevnik-0.0.1-SNAPSHOT/odradeni_dijelovi_specijalizacije/getAllBySpecijalizacija/{id}")
    fun getOdradeniDijeloviSpecijalizacije(@Path("id") specijalizacijaId : Int) : Call<ArrayList<OdradeniDioSpecijalizacije>>
}
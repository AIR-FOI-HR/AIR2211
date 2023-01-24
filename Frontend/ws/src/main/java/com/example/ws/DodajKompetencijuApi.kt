package com.example.ws

import com.example.core.entities.OdradenaKompetencija
import com.example.core.entities.SlucajBolesnika
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface DodajKompetencijuApi {
    @POST("/ednevnik-0.0.1-SNAPSHOT/odradene_kompetencije/add")
    fun dodajOdradenuKompetenciju (@Body odradenaKompetencija: OdradenaKompetencija) : Call<OdradenaKompetencija>
}
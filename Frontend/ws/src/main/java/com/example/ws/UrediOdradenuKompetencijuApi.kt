package com.example.ws

import com.example.core.entities.OdradenaKompetencija
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UrediOdradenuKompetencijuApi {
    @POST("/ednevnik-0.0.1-SNAPSHOT/odradene_kompetencije/update")
    fun urediOdradenuKompetenciju (@Body odradenaKompetencija: OdradenaKompetencija) : Call<OdradenaKompetencija>
}
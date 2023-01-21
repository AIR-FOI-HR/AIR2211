package com.example.ws

import com.example.core.entities.OdradeniZahvat
import com.example.core.entities.StrucniRad
import com.example.core.entities.Zahvat
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface DodajZahvatApi {
    @POST("/ednevnik-0.0.1-SNAPSHOT/odradeni_zahvati/add")
    fun dodajZahvat (@Body odradeniZahvat: OdradeniZahvat) : Call<OdradeniZahvat>
}
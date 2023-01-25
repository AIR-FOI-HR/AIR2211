package com.example.ws

import com.example.core.entities.OdradeniZahvat
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UrediOdradeniZahvatApi {
    @POST("/ednevnik-0.0.1-SNAPSHOT/odradeni_zahvati/update")
    fun urediOdradeniZahvat (@Body odradeniZahvat: OdradeniZahvat) : Call<OdradeniZahvat>
}
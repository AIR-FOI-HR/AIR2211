package com.example.ws

import com.example.core.entities.OdradeniDioSpecijalizacije
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UrediOdradeniDioSpecijalizacijeApi {
    @POST("/ednevnik-0.0.1-SNAPSHOT/odradeni_dijelovi_specijalizacije/update")
    fun urediOdradeniDioSpecijalizacije (@Body odradeniDioSpecijalizacije: OdradeniDioSpecijalizacije) : Call<OdradeniDioSpecijalizacije>
}
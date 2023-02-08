package com.example.ws

import com.example.core.entities.Mentor
import com.example.core.entities.Prijava
import com.example.core.entities.Specijalizant
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface SpecijalizantPrijavaApi {
    @POST("/ednevnik-0.0.1-SNAPSHOT/specijalizanti/prijava")
    fun specijalizantPrijava(@Body prijava: Prijava) : Call<Specijalizant>
}
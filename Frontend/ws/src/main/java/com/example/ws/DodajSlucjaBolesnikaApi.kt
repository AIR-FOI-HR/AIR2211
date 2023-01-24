package com.example.ws

import com.example.core.entities.SlucajBolesnika
import com.example.core.entities.Specijalizacija
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface DodajSlucjaBolesnikaApi {
    @POST("/ednevnik-0.0.1-SNAPSHOT/slucajevi_bolesnika/add")
    fun dodajSlucajBolesnika (@Body slucajBolesnika: SlucajBolesnika) : Call<SlucajBolesnika>
}
package com.example.ws

import com.example.core.entities.SlucajBolesnika
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UrediSlucajBolesnikaApi {
    @POST("/ednevnik-0.0.1-SNAPSHOT/slucajevi_bolesnika/update")
    fun urediSlucajBolesnika (@Body slucajBolesnika: SlucajBolesnika) : Call<SlucajBolesnika>
}
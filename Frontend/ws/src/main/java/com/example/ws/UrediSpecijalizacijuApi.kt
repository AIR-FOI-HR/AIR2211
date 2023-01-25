package com.example.ws

import com.example.core.entities.Specijalizacija
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UrediSpecijalizacijuApi {
    @POST("/ednevnik-0.0.1-SNAPSHOT/specijalizacija/update")
    fun urediSpecijalizaciju (@Body specijalizacija: Specijalizacija) : Call<Specijalizacija>
}
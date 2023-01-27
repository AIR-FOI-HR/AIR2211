package com.example.ws

import com.example.core.entities.Ispit
import com.example.core.entities.Specijalizant
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UrediSpecijalizantaApi {
    @POST("/ednevnik-0.0.1-SNAPSHOT/specijalizanti/update")
    fun urediSpecijalizanta (@Body specijalizant: Specijalizant) : Call<Specijalizant>
}
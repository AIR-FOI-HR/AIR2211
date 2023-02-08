package com.example.ws

import com.example.core.entities.Ispit
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UrediIspitApi {
    @POST("/ednevnik-0.0.1-SNAPSHOT/ispiti/update")
    fun urediIspit (@Body ispit: Ispit) : Call<Ispit>
}
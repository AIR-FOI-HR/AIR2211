package com.example.ws

import com.example.core.entities.Ispit
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface DodajIspitApi {
    @POST("/ednevnik-0.0.1-SNAPSHOT/ispiti/add")
    fun dodajIspit (@Body ispit: Ispit) : Call<Ispit>
}
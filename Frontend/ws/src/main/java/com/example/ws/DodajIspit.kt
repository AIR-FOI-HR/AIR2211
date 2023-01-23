package com.example.ws

import com.example.core.entities.Ispit
import com.example.core.entities.StrucniRad
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface DodajIspit {
    @POST("/ednevnik-0.0.1-SNAPSHOT/ispiti/add")
    fun dodajIspit (@Body ispit: Ispit) : Call<Ispit>
}
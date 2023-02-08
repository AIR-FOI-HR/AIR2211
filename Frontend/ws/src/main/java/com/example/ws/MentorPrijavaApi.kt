package com.example.ws

import com.example.core.entities.Mentor
import com.example.core.entities.Prijava
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface MentorPrijavaApi {
    @POST("/ednevnik-0.0.1-SNAPSHOT/mentori/prijava")
    fun mentorPrijava(@Body prijava: Prijava) : Call<Mentor>
}
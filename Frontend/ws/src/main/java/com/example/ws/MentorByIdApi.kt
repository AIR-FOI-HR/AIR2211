package com.example.ws

import com.example.core.entities.Mentor
import com.example.core.entities.SlucajBolesnika
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MentorByIdApi {
    @GET("/ednevnik-0.0.1-SNAPSHOT/mentori/getById/{id}")
    fun getMentor(@Path("id") mentorId : Int) : Call<Mentor>
}
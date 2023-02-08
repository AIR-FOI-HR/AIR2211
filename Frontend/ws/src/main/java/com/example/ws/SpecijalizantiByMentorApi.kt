package com.example.ws

import com.example.core.entities.Specijalizant
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface SpecijalizantiByMentorApi{
    @GET("/ednevnik-0.0.1-SNAPSHOT/specijalizanti/getAllByMentor/{id}")
    fun getSpecijalizantData(@Path("id") mentorId : Int) : Call<ArrayList<Specijalizant>>
}
package com.example.ws

import com.example.core.entities.Zahvat
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ZahvatByIdApi {
    @GET("/ednevnik-0.0.1-SNAPSHOT/zahvati/getById/{id}")
    fun getZahvat(@Path("id") zahvatId : Int) : Call<Zahvat>
}
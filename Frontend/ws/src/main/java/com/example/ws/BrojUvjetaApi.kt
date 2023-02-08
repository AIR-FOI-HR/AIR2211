package com.example.ws

import com.example.core.entities.DioSpecijalizacije
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface BrojUvjetaApi {
    @GET("/ednevnik-0.0.1-SNAPSHOT/programi_specijalizacije/getCountRequirementsById/{id}")
    fun getBrojUvjeta(@Path("id") programSpecijalizacijeId : Int) : Call<Int>
}
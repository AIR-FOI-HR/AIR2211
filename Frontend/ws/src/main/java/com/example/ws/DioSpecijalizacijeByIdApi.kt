package com.example.ws

import com.example.core.entities.DioSpecijalizacije
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface DioSpecijalizacijeByIdApi {
    @GET("/ednevnik-0.0.1-SNAPSHOT/dijelovi_specijalizacije/getById/{id}")
    fun getDioSpecijalizacije(@Path("id") dioSpecijalizacijeId : Int) : Call<DioSpecijalizacije>
}
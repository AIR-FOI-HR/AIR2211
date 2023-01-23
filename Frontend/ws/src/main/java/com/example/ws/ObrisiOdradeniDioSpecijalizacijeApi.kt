package com.example.ws

import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.Query

interface ObrisiOdradeniDioSpecijalizacijeApi {
    @DELETE("/ednevnik-0.0.1-SNAPSHOT/odradeni_dijelovi_specijalizacije/delete")
    fun obrisiOdradeniDioSpecijalizacije(@Query("specijalizacija") specijalizacija : Int, @Query("dioSpecijalizacije") dioSpecijalizacije : Int) : Call<Long>
}
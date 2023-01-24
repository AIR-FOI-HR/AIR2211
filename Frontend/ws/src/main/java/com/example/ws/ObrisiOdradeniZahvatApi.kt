package com.example.ws

import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.Query

interface ObrisiOdradeniZahvatApi {
    @DELETE("/ednevnik-0.0.1-SNAPSHOT/odradeni_zahvati/delete")
    fun obrisiOdradeniZahvat(@Query("specijalizacija") specijalizacija : Int, @Query("zahvat") zahvat : Int, @Query("stupanj") stupanj : Int) : Call<Long>
}
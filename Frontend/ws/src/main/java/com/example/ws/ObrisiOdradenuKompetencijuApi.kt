package com.example.ws

import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.Query

interface ObrisiOdradenuKompetencijuApi {
    @DELETE("/ednevnik-0.0.1-SNAPSHOT/odradene_kompetencije/delete")
    fun obrisiOdradenuKompetenciju(@Query("specijalizacija") specijalizacija : Int, @Query("kompetencija") kompetencija : Int, @Query("stupanj") stupanj : Int) : Call<Long>
}
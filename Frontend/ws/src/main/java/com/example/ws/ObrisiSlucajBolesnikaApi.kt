package com.example.ws

import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.Path

interface ObrisiSlucajBolesnikaApi {
    @DELETE("/ednevnik-0.0.1-SNAPSHOT/slucajevi_bolesnika/delete/{id}")
    fun obrisiSlucajBolesnika(@Path("id") slucajBolesnikaId : Int) : Call<Long>
}
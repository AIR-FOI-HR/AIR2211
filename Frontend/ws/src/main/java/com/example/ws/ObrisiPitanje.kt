package com.example.ws

import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.Path

interface ObrisiPitanje {
    @DELETE("/ednevnik-0.0.1-SNAPSHOT/pitanja/delete/{id}")
    fun obrisiPitanje(@Path("id") pitanjeId : Int) : Call<Long>
}
package com.example.ws

import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.Path

interface ObrisiProvjeruZnanja {
    @DELETE("/ednevnik-0.0.1-SNAPSHOT/provjere_znanja/delete/{id}")
    fun obrisiProvjeruZnanja(@Path("id") provjeraId : Int) : Call<Long>
}
package com.example.ws

import com.example.core.entities.ProvjeraZnanja
import com.example.core.entities.SlucajBolesnika
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface DodajProvjeruZnanjaApi {
    @POST("/ednevnik-0.0.1-SNAPSHOT/provjere_znanja/add")
    fun dodajProvjeruZnanja (@Body provjeraZnanja: ProvjeraZnanja) : Call<ProvjeraZnanja>
}
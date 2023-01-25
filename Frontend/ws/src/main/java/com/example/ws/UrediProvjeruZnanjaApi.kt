package com.example.ws

import com.example.core.entities.ProvjeraZnanja
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UrediProvjeruZnanjaApi {
    @POST("/ednevnik-0.0.1-SNAPSHOT/provjere_znanja/update")
    fun urediProvjeruZnanja (@Body provjeraZnanja: ProvjeraZnanja) : Call<ProvjeraZnanja>
}
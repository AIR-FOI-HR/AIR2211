package com.example.ws

import com.example.core.entities.UstrojstvenaJedinica
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface UstrojstvenaJedinicaByIdApi {
    @GET("/ednevnik-0.0.1-SNAPSHOT/ustrojstvene_jedinice/getById/{id}")
    fun getUstrojstvenaJedinica(@Path("id") ustrojstvenaJedinicaId : Int) : Call<UstrojstvenaJedinica>
}
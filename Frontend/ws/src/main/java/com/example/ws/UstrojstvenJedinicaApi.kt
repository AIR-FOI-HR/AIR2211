package com.example.ws

import com.example.core.entities.UstrojstvenaJedinica
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface UstrojstvenJedinicaApi {
    @GET("/ednevnik-0.0.1-SNAPSHOT/ustrojstvene_jedinice/getCurrentBySpecijalizantId/{id}")
    fun getLokacija(@Path("id") specijalizantId : Int) : Call<UstrojstvenaJedinica>
}
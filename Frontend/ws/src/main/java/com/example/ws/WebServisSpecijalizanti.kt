package com.example.ws

import com.example.core.entities.Specijalizant
import retrofit2.Call
import retrofit2.http.GET

interface WebServisSpecijalizanti {

    @GET("/specijalizanti/get")
    fun getSpecijalizantData() : Call<ArrayList<Specijalizant>>
}
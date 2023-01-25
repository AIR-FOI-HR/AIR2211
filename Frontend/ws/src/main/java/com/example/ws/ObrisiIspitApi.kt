package com.example.ws

import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.Path

interface ObrisiIspitApi {
    @DELETE("/ednevnik-0.0.1-SNAPSHOT/ispiti/delete/{id}")
    fun obrisiIspit(@Path("id") ispitId : Int) : Call<Long>
}
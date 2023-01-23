package com.example.ws

import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.Path

interface ObrisiStrucniRad {
    @DELETE("/ednevnik-0.0.1-SNAPSHOT/strucni_radovi/delete/{id}")
    fun obrisiStrucniRad(@Path("id") strucniRadId : Int) : Call<Long>
}
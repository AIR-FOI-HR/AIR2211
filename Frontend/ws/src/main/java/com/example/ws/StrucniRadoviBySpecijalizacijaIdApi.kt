package com.example.ws

import com.example.core.entities.StrucniRad
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface StrucniRadoviBySpecijalizacijaIdApi {
    @GET("/ednevnik-0.0.1-SNAPSHOT/strucni_radovi/getAllBySpecijalizacijaId/{id}")
    fun getStrucniRadovi(@Path("id") specijalizacijaId : Int) : Call<ArrayList<StrucniRad>>
}
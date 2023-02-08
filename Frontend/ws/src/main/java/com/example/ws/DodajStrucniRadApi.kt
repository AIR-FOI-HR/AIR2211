package com.example.ws

import com.example.core.entities.SlucajBolesnika
import com.example.core.entities.StrucniRad
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface DodajStrucniRadApi {
    @POST("/ednevnik-0.0.1-SNAPSHOT/strucni_radovi/add")
    fun dodajStrucniRad (@Body strucniRad: StrucniRad) : Call<StrucniRad>
}
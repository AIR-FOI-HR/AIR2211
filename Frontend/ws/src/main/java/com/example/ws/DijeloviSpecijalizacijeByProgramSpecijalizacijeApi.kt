package com.example.ws

import com.example.core.entities.DioSpecijalizacije
import com.example.core.entities.Kompetencija
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface DijeloviSpecijalizacijeByProgramSpecijalizacijeApi {
    @GET("/ednevnik-0.0.1-SNAPSHOT/dijelovi_specijalizacije/getAllByProgramSpecijalizacijeId/{id}")
    fun getDijeloviSpecijalizacije(@Path("id") programSpecijalizacijeId : Int) : Call<ArrayList<DioSpecijalizacije>>
}
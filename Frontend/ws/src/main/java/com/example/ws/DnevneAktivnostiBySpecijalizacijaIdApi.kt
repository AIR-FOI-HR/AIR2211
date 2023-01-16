package com.example.ws

import com.example.core.entities.DnevnaAktivnost
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface DnevneAktivnostiBySpecijalizacijaIdApi {
    @GET("/ednevnik-0.0.1-SNAPSHOT/dnevne_aktivnosti/getAllBySpecijalizacijaId/{id}")
    fun getDnevneAktivnosti(@Path("id") specijalizacijaId : Int) : Call<ArrayList<DnevnaAktivnost>>
}
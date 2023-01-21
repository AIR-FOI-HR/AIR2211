package com.example.ws

import com.example.core.entities.DnevnaAktivnost
import com.example.core.entities.SlucajBolesnika
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface DodajDnevnuAktivnostApi {
    @POST("/ednevnik-0.0.1-SNAPSHOT/dnevne_aktivnosti/add")
    fun dodajDnevnuAktivnost (@Body dnevnaAktivnost: DnevnaAktivnost) : Call<DnevnaAktivnost>
}
package com.example.ws

import com.example.core.entities.DnevnaAktivnost
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UrediDnevnuAktivnostApi {
    @POST("/ednevnik-0.0.1-SNAPSHOT/dnevne_aktivnosti/update")
    fun urediDnevnuAktivnost (@Body dnevnaAktivnost: DnevnaAktivnost) : Call<DnevnaAktivnost>
}
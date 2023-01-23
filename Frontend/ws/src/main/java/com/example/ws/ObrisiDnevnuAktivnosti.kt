package com.example.ws

import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.Path

interface ObrisiDnevnuAktivnosti {
    @DELETE("/ednevnik-0.0.1-SNAPSHOT/dnevne_aktivnosti/delete/{id}")
    fun obrisiDnevnuAktivnost(@Path("id") dnevnaAktivnostId : Int) : Call<Long>
}
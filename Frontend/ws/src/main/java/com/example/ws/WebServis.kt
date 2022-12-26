package com.example.ws

import android.util.Log
import com.example.core.entities.Specijalizant
import okhttp3.OkHttpClient
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

object WebServis {
    lateinit var retrofit : Retrofit
    val baseUrl : String = "http://104.248.37.213:8080/ednevnik-0.0.1-SNAPSHOT/"
    public var specijalizanti: ArrayList<Specijalizant>? = ArrayList()

    init {
        retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient())
            .build()
        Log.d("Debug", "Webservis kreiran")

        getAllSpecijalizanti()
    }

    fun getAllSpecijalizanti()
    {
        val serviceAPI = retrofit.create(WebServisSpecijalizanti::class.java)
        val call : Call<ArrayList<Specijalizant>> = serviceAPI.getSpecijalizantData()
        call.enqueue (
            object : Callback<ArrayList<Specijalizant>>{

                override fun onResponse(
                    call: Call<ArrayList<Specijalizant>>,
                    response: Response<ArrayList<Specijalizant>>,
                ) {
                    try {
                        if(response != null)
                        {
                            specijalizanti = response.body()
                        }
                        else {
                            Log.d("Debug", "Odgvor je nula")
                        }
                    }
                    catch (ex: Exception) {
                        Log.d("Debug", ex.toString())
                    }
                }

                override fun onFailure(call: Call<ArrayList<Specijalizant>>, t: Throwable) {
                    Log.d("Debug", "Neuspjesno dohvacanje")
                }
            }
        )
    }
}
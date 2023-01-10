package com.example.ws

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.core.entities.Specijalizant
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class SpecijalizantiWebServis {

    companion object {
        private const val BASE_URL: String = "http://104.248.37.213:8080/"
    }

    private var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(
            OkHttpClient.Builder()
                .addInterceptor(
                    HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BODY)
                )
                .build()
        )
        .build()

    private val _specijalizanti = MutableLiveData<List<Specijalizant>>()
    val specijalizanti: LiveData<List<Specijalizant>>
        get() = _specijalizanti

    fun getAllSpecijalizanti()
    {
        val serviceAPI = retrofit.create(SpecijalizantiApi::class.java)
        val call : Call<ArrayList<Specijalizant>> = serviceAPI.getSpecijalizantData()

        call.enqueue (
            object : Callback<ArrayList<Specijalizant>>{
                override fun onResponse(
                    call: Call<ArrayList<Specijalizant>>,
                    response: Response<ArrayList<Specijalizant>>,
                ) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    if (response.isSuccessful) {
                        _specijalizanti.value = response.body()
                        Log.d("TAG", "onResponse success: ${response.body()}")
                    }
                }

                override fun onFailure(call: Call<ArrayList<Specijalizant>>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                }
            }
        )
    }

    fun getAllSpecijalizantiByMentorId(mentorId : Int)
    {
        val serviceAPI = retrofit.create(SpecijalizantiByMentorApi::class.java)
        val call : Call<ArrayList<Specijalizant>> = serviceAPI.getSpecijalizantData(mentorId)

        call.enqueue (
            object : Callback<ArrayList<Specijalizant>>{
                override fun onResponse(
                    call: Call<ArrayList<Specijalizant>>,
                    response: Response<ArrayList<Specijalizant>>,
                ) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    if (response.isSuccessful) {
                        _specijalizanti.value = response.body()
                        Log.d("TAG", "onResponse success: ${response.body()}")
                    }
                }

                override fun onFailure(call: Call<ArrayList<Specijalizant>>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                }
            }
        )
    }
}
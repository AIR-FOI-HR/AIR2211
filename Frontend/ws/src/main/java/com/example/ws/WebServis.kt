package com.example.ws

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.core.entities.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class WebServis {

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


    //Specijalizanti
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

    //Specijalizacija
    private val _specijalizacija = MutableLiveData<Specijalizacija>()
    val specijalizacija: LiveData<Specijalizacija>
        get() = _specijalizacija

    fun getSpecijalizacija(specijalizantId : Int)
    {
        val serviceAPI = retrofit.create(SpecijalizacijaBySpecijalizantApi::class.java)
        val call : Call<Specijalizacija> = serviceAPI.getSpecijalizacijaData(specijalizantId)

        call.enqueue (
            object : Callback<Specijalizacija>{
                override fun onResponse(
                    call: Call<Specijalizacija>,
                    response: Response<Specijalizacija>,
                ) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    if (response.isSuccessful) {
                        _specijalizacija.value = response.body()
                        Log.d("TAG", "onResponse success: ${response.body()}")
                    }
                }

                override fun onFailure(call: Call<Specijalizacija>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                }
            }
        )
    }

    //Slucaj bolesnika
    private val _slucajeviBolesnika = MutableLiveData<List<SlucajBolesnika>>()
    val slucajeviBolesnika: LiveData<List<SlucajBolesnika>>
        get() = _slucajeviBolesnika

    fun getAllSlucajeviBolesnika(specijalizacijaId : Int)
    {
        val serviceAPI = retrofit.create(SlucajeviBolesnikaBySpecijalizacijaIdApi::class.java)
        val call : Call<ArrayList<SlucajBolesnika>> = serviceAPI.getSlucajeviBolesnika(specijalizacijaId)

        call.enqueue (
            object : Callback<ArrayList<SlucajBolesnika>>{
                override fun onResponse(
                    call: Call<ArrayList<SlucajBolesnika>>,
                    response: Response<ArrayList<SlucajBolesnika>>,
                ) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    if (response.isSuccessful) {
                        _slucajeviBolesnika.value = response.body()
                        Log.d("TAG", "onResponse success: ${response.body()}")
                    }
                }

                override fun onFailure(call: Call<ArrayList<SlucajBolesnika>>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                }
            }
        )
    }

    private val _slucajBolesnika = MutableLiveData<SlucajBolesnika>()
    val slucajBolesnika: LiveData<SlucajBolesnika>
        get() = _slucajBolesnika

    fun getSlucajBolesnika(slucajBolesnikaId : Int)
    {
        val serviceAPI = retrofit.create(SlucajBolesnikaByIdApi::class.java)
        val call : Call<SlucajBolesnika> = serviceAPI.getSlucajBolesnika(slucajBolesnikaId)

        call.enqueue (
            object : Callback<SlucajBolesnika>{
                override fun onResponse(
                    call: Call<SlucajBolesnika>,
                    response: Response<SlucajBolesnika>,
                ) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    if (response.isSuccessful) {
                        _slucajBolesnika.value = response.body()
                        Log.d("TAG", "onResponse success: ${response.body()}")
                    }
                }

                override fun onFailure(call: Call<SlucajBolesnika>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                }
            }
        )
    }

    //Strucni rad
    private val _strucniRadovi = MutableLiveData<List<StrucniRad>>()
    val strucniRadovi: LiveData<List<StrucniRad>>
        get() = _strucniRadovi

    fun getAllStrucniRadovi(specijalizacijaId : Int)
    {
        val serviceAPI = retrofit.create(StrucniRadoviBySpecijalizacijaIdApi::class.java)
        val call : Call<ArrayList<StrucniRad>> = serviceAPI.getStrucniRadovi(specijalizacijaId)

        call.enqueue (
            object : Callback<ArrayList<StrucniRad>>{
                override fun onResponse(
                    call: Call<ArrayList<StrucniRad>>,
                    response: Response<ArrayList<StrucniRad>>,
                ) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    if (response.isSuccessful) {
                        _strucniRadovi.value = response.body()
                        Log.d("TAG", "onResponse success: ${response.body()}")
                    }
                }

                override fun onFailure(call: Call<ArrayList<StrucniRad>>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                }
            }
        )
    }

    //Dnevna aktivnost
    private val _dnevneAktivnosti = MutableLiveData<List<DnevnaAktivnost>>()
    val dnevneAktivnosti: LiveData<List<DnevnaAktivnost>>
        get() = _dnevneAktivnosti

    fun getAllDnevneAktivnosti(specijalizacijaId : Int)
    {
        val serviceAPI = retrofit.create(DnevneAktivnostiBySpecijalizacijaIdApi::class.java)
        val call : Call<ArrayList<DnevnaAktivnost>> = serviceAPI.getDnevneAktivnosti(specijalizacijaId)

        call.enqueue (
            object : Callback<ArrayList<DnevnaAktivnost>>{
                override fun onResponse(
                    call: Call<ArrayList<DnevnaAktivnost>>,
                    response: Response<ArrayList<DnevnaAktivnost>>,
                ) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    if (response.isSuccessful) {
                        _dnevneAktivnosti.value = response.body()
                        Log.d("TAG", "onResponse success: ${response.body()}")
                    }
                }

                override fun onFailure(call: Call<ArrayList<DnevnaAktivnost>>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                }
            }
        )
    }
}
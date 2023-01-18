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

    //Provjera znanja
    private val _provjereZnanja = MutableLiveData<List<ProvjeraZnanja>>()
    val provjereZnanja: LiveData<List<ProvjeraZnanja>>
        get() = _provjereZnanja

    fun getAllProvjereZnanja(specijalizacijaId : Int)
    {
        val serviceAPI = retrofit.create(ProvjereZnanjaBySpecijalizacijaIdApi::class.java)
        val call : Call<ArrayList<ProvjeraZnanja>> = serviceAPI.getProvjereZnanja(specijalizacijaId)

        call.enqueue (
            object : Callback<ArrayList<ProvjeraZnanja>>{
                override fun onResponse(
                    call: Call<ArrayList<ProvjeraZnanja>>,
                    response: Response<ArrayList<ProvjeraZnanja>>,
                ) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    if (response.isSuccessful) {
                        _provjereZnanja.value = response.body()
                        Log.d("TAG", "onResponse success: ${response.body()}")
                    }
                }

                override fun onFailure(call: Call<ArrayList<ProvjeraZnanja>>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                }
            }
        )
    }

    //Pitanje
    private val _pitanja = MutableLiveData<List<Pitanje>>()
    val pitanja: LiveData<List<Pitanje>>
        get() = _pitanja

    fun getAllPitanja(provjeraId : Int)
    {
        val serviceAPI = retrofit.create(PitanjaByProvjeraIdApi::class.java)
        val call : Call<ArrayList<Pitanje>> = serviceAPI.getPitanja(provjeraId)

        call.enqueue (
            object : Callback<ArrayList<Pitanje>>{
                override fun onResponse(
                    call: Call<ArrayList<Pitanje>>,
                    response: Response<ArrayList<Pitanje>>,
                ) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    if (response.isSuccessful) {
                        _pitanja.value = response.body()
                        Log.d("TAG", "onResponse success: ${response.body()}")
                    }
                }

                override fun onFailure(call: Call<ArrayList<Pitanje>>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                }
            }
        )
    }

    //Kompetencija
    private val _kompetencija = MutableLiveData<Kompetencija>()
    val kompetencija: LiveData<Kompetencija>
        get() = _kompetencija

    fun getKompetencija(kompetencijaId : Int)
    {
        val serviceAPI = retrofit.create(KompetencijaByIdApi::class.java)
        val call : Call<Kompetencija> = serviceAPI.getKompetencija(kompetencijaId)

        call.enqueue (
            object : Callback<Kompetencija>{
                override fun onResponse(
                    call: Call<Kompetencija>,
                    response: Response<Kompetencija>,
                ) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    if (response.isSuccessful) {
                        _kompetencija.value = response.body()
                        Log.d("TAG", "onResponse success: ${response.body()}")
                    }
                }

                override fun onFailure(call: Call<Kompetencija>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                }
            }
        )
    }

    //Zahvat
    private val _zahvat = MutableLiveData<Zahvat>()
    val zahvat: LiveData<Zahvat>
        get() = _zahvat

    fun getZahvat(zahvatId : Int)
    {
        val serviceAPI = retrofit.create(ZahvatByIdApi::class.java)
        val call : Call<Zahvat> = serviceAPI.getZahvat(zahvatId)

        call.enqueue (
            object : Callback<Zahvat>{
                override fun onResponse(
                    call: Call<Zahvat>,
                    response: Response<Zahvat>,
                ) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    if (response.isSuccessful) {
                        _zahvat.value = response.body()
                        Log.d("TAG", "onResponse success: ${response.body()}")
                    }
                }

                override fun onFailure(call: Call<Zahvat>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                }
            }
        )
    }

    //Dio specijalizacije
    private val _dioSpecijalizacije = MutableLiveData<DioSpecijalizacije>()
    val dioSpecijalizacije: LiveData<DioSpecijalizacije>
        get() = _dioSpecijalizacije

    fun getDioSpecijalizacije(dioSpecijalizacijeId : Int)
    {
        val serviceAPI = retrofit.create(DioSpecijalizacijeByIdApi::class.java)
        val call : Call<DioSpecijalizacije> = serviceAPI.getDioSpecijalizacije(dioSpecijalizacijeId)

        call.enqueue (
            object : Callback<DioSpecijalizacije>{
                override fun onResponse(
                    call: Call<DioSpecijalizacije>,
                    response: Response<DioSpecijalizacije>,
                ) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    if (response.isSuccessful) {
                        _dioSpecijalizacije.value = response.body()
                        Log.d("TAG", "onResponse success: ${response.body()}")
                    }
                }

                override fun onFailure(call: Call<DioSpecijalizacije>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                }
            }
        )
    }

    //Ustrojstvena jedinica
    private val _ustrojstvenaJedinica = MutableLiveData<UstrojstvenaJedinica>()
    val ustrojstvenaJedinica: LiveData<UstrojstvenaJedinica>
        get() = _ustrojstvenaJedinica

    fun getUstrojstvenaJedinica(ustrojstvenaJedinicaId : Int)
    {
        val serviceAPI = retrofit.create(UstrojstvenaJedinicaByIdApi::class.java)
        val call : Call<UstrojstvenaJedinica> = serviceAPI.getUstrojstvenaJedinica(ustrojstvenaJedinicaId)

        call.enqueue (
            object : Callback<UstrojstvenaJedinica>{
                override fun onResponse(
                    call: Call<UstrojstvenaJedinica>,
                    response: Response<UstrojstvenaJedinica>,
                ) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    if (response.isSuccessful) {
                        _ustrojstvenaJedinica.value = response.body()
                        Log.d("TAG", "onResponse success: ${response.body()}")
                    }
                }

                override fun onFailure(call: Call<UstrojstvenaJedinica>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                }
            }
        )
    }

    //Odradena kompetencija
    private val _odradeneKompetencije = MutableLiveData<List<OdradenaKompetencija>>()
    val odradeneKompetencije: LiveData<List<OdradenaKompetencija>>
        get() = _odradeneKompetencije

    fun getAllOdradeneKompetencije(specijalizacijaId : Int)
    {
        val serviceAPI = retrofit.create(OdradeneKompetencijeBySpecijalizacijaId::class.java)
        val call : Call<ArrayList<OdradenaKompetencija>> = serviceAPI.getOdradeneKompetencijie(specijalizacijaId)

        call.enqueue (
            object : Callback<ArrayList<OdradenaKompetencija>>{
                override fun onResponse(
                    call: Call<ArrayList<OdradenaKompetencija>>,
                    response: Response<ArrayList<OdradenaKompetencija>>,
                ) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    if (response.isSuccessful) {
                        _odradeneKompetencije.value = response.body()
                        Log.d("TAG", "onResponse success: ${response.body()}")
                    }
                }

                override fun onFailure(call: Call<ArrayList<OdradenaKompetencija>>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                }
            }
        )
    }

    //Odradeni zahvat
    private val _odradeniZahvati = MutableLiveData<List<OdradeniZahvat>>()
    val odradeniZahvati: LiveData<List<OdradeniZahvat>>
        get() = _odradeniZahvati

    fun getAllOdradeniZahvati(specijalizacijaId : Int)
    {
        val serviceAPI = retrofit.create(OdradeniZahvatiBySpecijalizacijaId::class.java)
        val call : Call<ArrayList<OdradeniZahvat>> = serviceAPI.getOdradeniZahvati(specijalizacijaId)

        call.enqueue (
            object : Callback<ArrayList<OdradeniZahvat>>{
                override fun onResponse(
                    call: Call<ArrayList<OdradeniZahvat>>,
                    response: Response<ArrayList<OdradeniZahvat>>,
                ) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    if (response.isSuccessful) {
                        _odradeniZahvati.value = response.body()
                        Log.d("TAG", "onResponse success: ${response.body()}")
                    }
                }

                override fun onFailure(call: Call<ArrayList<OdradeniZahvat>>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                }
            }
        )
    }

    //Odradeni dio specijalizacije
    private val _odradeniDijeloviSpecijalizacije = MutableLiveData<List<OdradeniDioSpecijalizacije>>()
    val odradeniDijeloviSpecijalizacije: LiveData<List<OdradeniDioSpecijalizacije>>
        get() = _odradeniDijeloviSpecijalizacije

    fun getAllOdradeniDijeloviSpecijalizacije(specijalizacijaId : Int)
    {
        val serviceAPI = retrofit.create(OdradeniDijeloviSpecijalizacijeBySpecijalizacijaId::class.java)
        val call : Call<ArrayList<OdradeniDioSpecijalizacije>> = serviceAPI.getOdradeniDijeloviSpecijalizacije(specijalizacijaId)

        call.enqueue (
            object : Callback<ArrayList<OdradeniDioSpecijalizacije>>{
                override fun onResponse(
                    call: Call<ArrayList<OdradeniDioSpecijalizacije>>,
                    response: Response<ArrayList<OdradeniDioSpecijalizacije>>,
                ) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    if (response.isSuccessful) {
                        _odradeniDijeloviSpecijalizacije.value = response.body()
                        Log.d("TAG", "onResponse success: ${response.body()}")
                    }
                }

                override fun onFailure(call: Call<ArrayList<OdradeniDioSpecijalizacije>>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                }
            }
        )
    }

    //Mentor
    private val _mentor = MutableLiveData<Mentor>()
    val mentor: LiveData<Mentor>
        get() = _mentor

    fun getMentor(mentorId : Int)
    {
        val serviceAPI = retrofit.create(MentorByIdApi::class.java)
        val call : Call<Mentor> = serviceAPI.getMentor(mentorId)

        call.enqueue (
            object : Callback<Mentor>{
                override fun onResponse(
                    call: Call<Mentor>,
                    response: Response<Mentor>,
                ) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    if (response.isSuccessful) {
                        _mentor.value = response.body()
                        Log.d("TAG", "onResponse success: ${response.body()}")
                    }
                }

                override fun onFailure(call: Call<Mentor>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                }
            }
        )
    }


}
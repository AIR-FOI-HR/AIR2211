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

    fun urediSpecijalizanta(specijalizant: Specijalizant, onResult: (Specijalizant?) -> Unit){
        val serviceAPI = retrofit.create(UrediSpecijalizantaApi::class.java)
        serviceAPI.urediSpecijalizanta(specijalizant).enqueue(
            object : Callback<Specijalizant> {
                override fun onFailure(call: Call<Specijalizant>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                    onResult(null)
                }
                override fun onResponse( call: Call<Specijalizant>, response: Response<Specijalizant>) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    if (response.isSuccessful) {
                        val specijalizantUred = response.body()
                        onResult(specijalizantUred)
                        Log.d("TAG", "onResponse success: ${response.body()}")
                    }
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
                    _specijalizacija.value = null
                }
            }
        )
    }


    fun getSpecijalizacijaById(specijalizacijaId : Int)
    {
        val serviceAPI = retrofit.create(SpecijalizacijaByIdApi::class.java)
        val call : Call<Specijalizacija> = serviceAPI.getSpecijalizacijaById(specijalizacijaId)

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

    fun dodajSpecijalizaciju(specijalizacija: Specijalizacija, onResult: (Specijalizacija?) -> Unit){
        val serviceAPI = retrofit.create(DodajSpecijalizacijuApi::class.java)
        serviceAPI.dodajSpecijalizaciju(specijalizacija).enqueue(
            object : Callback<Specijalizacija> {
                override fun onFailure(call: Call<Specijalizacija>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                    onResult(null)
                }
                override fun onResponse( call: Call<Specijalizacija>, response: Response<Specijalizacija>) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    if (response.isSuccessful) {
                        val dodanaSpecijalizacija = response.body()
                        onResult(dodanaSpecijalizacija)
                        Log.d("TAG", "onResponse success: ${response.body()}")
                    }
                }
            }
        )
    }

    fun urediSpecijalizaciju(specijalizacija: Specijalizacija, onResult: (Specijalizacija?) -> Unit){
        val serviceAPI = retrofit.create(UrediSpecijalizacijuApi::class.java)
        serviceAPI.urediSpecijalizaciju(specijalizacija).enqueue(
            object : Callback<Specijalizacija> {
                override fun onFailure(call: Call<Specijalizacija>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                    onResult(null)
                }
                override fun onResponse( call: Call<Specijalizacija>, response: Response<Specijalizacija>) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    if (response.isSuccessful) {
                        val uredenaSpecijalizacija = response.body()
                        onResult(uredenaSpecijalizacija)
                        Log.d("TAG", "onResponse success: ${response.body()}")
                    }
                }
            }
        )
    }

    private val _brojUvjeta = MutableLiveData<Int>()
    val brojUvjeta: LiveData<Int>
        get() = _brojUvjeta

    fun getBrojUvjeta(programSpecijalizacijeId : Int)
    {
        val serviceAPI = retrofit.create(BrojUvjetaApi::class.java)
        val call : Call<Int> = serviceAPI.getBrojUvjeta(programSpecijalizacijeId)

        call.enqueue (
            object : Callback<Int>{
                override fun onResponse(
                    call: Call<Int>,
                    response: Response<Int>,
                ) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    if (response.isSuccessful) {
                         _brojUvjeta.value = response.body()
                        Log.d("TAG", "onResponse success: ${response.body()}")
                    }
                }

                override fun onFailure(call: Call<Int>, t: Throwable) {
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

    fun dodajSlucajBolesnika(slucajBolesnika: SlucajBolesnika, onResult: (SlucajBolesnika?) -> Unit){
        val serviceAPI = retrofit.create(DodajSlucajBolesnikaApi::class.java)
        serviceAPI.dodajSlucajBolesnika(slucajBolesnika).enqueue(
            object : Callback<SlucajBolesnika> {
                override fun onFailure(call: Call<SlucajBolesnika>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                    onResult(null)
                }
                override fun onResponse( call: Call<SlucajBolesnika>, response: Response<SlucajBolesnika>) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    if (response.isSuccessful) {
                        val dodanSlucajBolesnika = response.body()
                        onResult(dodanSlucajBolesnika)
                        Log.d("TAG", "onResponse success: ${response.body()}")
                    }
                }
            }
        )
    }

    fun obrisiSlucajBolesnika(slucajBolesnikaId: Int, onResult: (Long?) -> Unit){
        val serviceAPI = retrofit.create(ObrisiSlucajBolesnikaApi::class.java)
        serviceAPI.obrisiSlucajBolesnika(slucajBolesnikaId).enqueue(
            object : Callback<Long> {
                override fun onFailure(call: Call<Long>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                    onResult(null)
                }
                override fun onResponse( call: Call<Long>, response: Response<Long>) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    if (response.isSuccessful) {
                        val obrisanSlucajBolesnika = response.body()
                        onResult(obrisanSlucajBolesnika)
                        Log.d("TAG", "onResponse success: ${response.body()}")
                    }
                }
            }
        )
    }

    fun urediSlucajBolesnika(slucajBolesnika: SlucajBolesnika, onResult: (SlucajBolesnika?) -> Unit){
        val serviceAPI = retrofit.create(UrediSlucajBolesnikaApi::class.java)
        serviceAPI.urediSlucajBolesnika(slucajBolesnika).enqueue(
            object : Callback<SlucajBolesnika> {
                override fun onFailure(call: Call<SlucajBolesnika>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                    onResult(null)
                }
                override fun onResponse( call: Call<SlucajBolesnika>, response: Response<SlucajBolesnika>) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    if (response.isSuccessful) {
                        val uredenSlucajBolesnika = response.body()
                        onResult(uredenSlucajBolesnika)
                        Log.d("TAG", "onResponse success: ${response.body()}")
                    }
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

    fun dodajStrucniRad(strucniRad: StrucniRad, onResult: (StrucniRad?) -> Unit){
        val serviceAPI = retrofit.create(DodajStrucniRadApi::class.java)
        serviceAPI.dodajStrucniRad(strucniRad).enqueue(
            object : Callback<StrucniRad> {
                override fun onFailure(call: Call<StrucniRad>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                    onResult(null)
                }
                override fun onResponse( call: Call<StrucniRad>, response: Response<StrucniRad>) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    if (response.isSuccessful) {
                        val dodanStrucniRad = response.body()
                        onResult(dodanStrucniRad)
                        Log.d("TAG", "onResponse success: ${response.body()}")
                    }
                }
            }
        )
    }

    fun obrisiStrucniRad(strucniRadId: Int, onResult: (Long?) -> Unit){
        val serviceAPI = retrofit.create(ObrisiStrucniRadApi::class.java)
        serviceAPI.obrisiStrucniRad(strucniRadId).enqueue(
            object : Callback<Long> {
                override fun onFailure(call: Call<Long>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                    onResult(null)
                }
                override fun onResponse( call: Call<Long>, response: Response<Long>) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    if (response.isSuccessful) {
                        val obrisanStrucniRad = response.body()
                        onResult(obrisanStrucniRad)
                        Log.d("TAG", "onResponse success: ${response.body()}")
                    }
                }
            }
        )
    }

    fun urediStrucniRad(strucniRad: StrucniRad, onResult: (StrucniRad?) -> Unit){
        val serviceAPI = retrofit.create(UrediStrucniRadApi::class.java)
        serviceAPI.urediStrucniRad(strucniRad).enqueue(
            object : Callback<StrucniRad> {
                override fun onFailure(call: Call<StrucniRad>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                    onResult(null)
                }
                override fun onResponse( call: Call<StrucniRad>, response: Response<StrucniRad>) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    if (response.isSuccessful) {
                        val uredenStrucniRad = response.body()
                        onResult(uredenStrucniRad)
                        Log.d("TAG", "onResponse success: ${response.body()}")
                    }
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

    fun dodajDnevnuAktivnost(dnevnaAktivnost: DnevnaAktivnost, onResult: (DnevnaAktivnost?) -> Unit){
        val serviceAPI = retrofit.create(DodajDnevnuAktivnostApi::class.java)
        serviceAPI.dodajDnevnuAktivnost(dnevnaAktivnost).enqueue(
            object : Callback<DnevnaAktivnost> {
                override fun onFailure(call: Call<DnevnaAktivnost>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                    onResult(null)
                }
                override fun onResponse( call: Call<DnevnaAktivnost>, response: Response<DnevnaAktivnost>) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    if (response.isSuccessful) {
                        val dodanaDnevnaAktivnost = response.body()
                        onResult(dodanaDnevnaAktivnost)
                        Log.d("TAG", "onResponse success: ${response.body()}")
                    }
                }
            }
        )
    }

    fun obrisiDnevnuAktivnost(dnevnaAktivnostId: Int, onResult: (Long?) -> Unit) {
        val serviceAPI = retrofit.create(ObrisiDnevnuAktivnostiApi::class.java)
        serviceAPI.obrisiDnevnuAktivnost(dnevnaAktivnostId).enqueue(
            object : Callback<Long> {
                override fun onFailure(call: Call<Long>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                    onResult(null)
                }

                override fun onResponse(call: Call<Long>, response: Response<Long>) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    if (response.isSuccessful) {
                        val obrisanaDnevnaAktivnost = response.body()
                        onResult(obrisanaDnevnaAktivnost)
                        Log.d("TAG", "onResponse success: ${response.body()}")
                    }
                }
            }
        )
    }

    fun urediDnevnuAktivnost(dnevnaAktivnost: DnevnaAktivnost, onResult: (DnevnaAktivnost?) -> Unit){
        val serviceAPI = retrofit.create(UrediDnevnuAktivnostApi::class.java)
        serviceAPI.urediDnevnuAktivnost(dnevnaAktivnost).enqueue(
            object : Callback<DnevnaAktivnost> {
                override fun onFailure(call: Call<DnevnaAktivnost>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                    onResult(null)
                }
                override fun onResponse( call: Call<DnevnaAktivnost>, response: Response<DnevnaAktivnost>) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    if (response.isSuccessful) {
                        val uredenaDnevnaAktivnost = response.body()
                        onResult(uredenaDnevnaAktivnost)
                        Log.d("TAG", "onResponse success: ${response.body()}")
                    }
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

    fun dodajProvjeruZnanja(provjeraZnanja: ProvjeraZnanja, onResult: (ProvjeraZnanja?) -> Unit){
        val serviceAPI = retrofit.create(DodajProvjeruZnanjaApi::class.java)
        serviceAPI.dodajProvjeruZnanja(provjeraZnanja).enqueue(
            object : Callback<ProvjeraZnanja> {
                override fun onFailure(call: Call<ProvjeraZnanja>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                    onResult(null)
                }
                override fun onResponse( call: Call<ProvjeraZnanja>, response: Response<ProvjeraZnanja>) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    if (response.isSuccessful) {
                        val dodanaProvjeraZnanja = response.body()
                        onResult(dodanaProvjeraZnanja)
                        Log.d("TAG", "onResponse success: ${response.body()}")
                    }
                }
            }
        )
    }


    private val _provjeraZnanja = MutableLiveData<ProvjeraZnanja>()
    val provjeraZnanja: LiveData<ProvjeraZnanja>
        get() = _provjeraZnanja
    fun getProvjeraZnanja(provjeraZnanjaId : Int)
    {
        val serviceAPI = retrofit.create(ProvjeraZnanjaByIdApi::class.java)
        val call : Call<ProvjeraZnanja> = serviceAPI.getProvjeraZnanja(provjeraZnanjaId)

        call.enqueue (
            object : Callback<ProvjeraZnanja>{
                override fun onResponse(
                    call: Call<ProvjeraZnanja>,
                    response: Response<ProvjeraZnanja>,
                ) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    if (response.isSuccessful) {
                        _provjeraZnanja.value = response.body()
                        Log.d("TAG", "onResponse success: ${response.body()}")
                    }
                }

                override fun onFailure(call: Call<ProvjeraZnanja>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                }
            }
        )
    }

    fun obrisiProvjeruZnanja(provjeraId: Int, onResult: (Long?) -> Unit) {
        val serviceAPI = retrofit.create(ObrisiProvjeruZnanjaApi::class.java)
        serviceAPI.obrisiProvjeruZnanja(provjeraId).enqueue(
            object : Callback<Long> {
                override fun onFailure(call: Call<Long>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                    onResult(null)
                }

                override fun onResponse(call: Call<Long>, response: Response<Long>) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    if (response.isSuccessful) {
                        val obrisanaProvjeraZnanja = response.body()
                        onResult(obrisanaProvjeraZnanja)
                        Log.d("TAG", "onResponse success: ${response.body()}")
                    }
                }
            }
        )
    }

    fun urediProvjeruZnanja(provjeraZnanja: ProvjeraZnanja, onResult: (ProvjeraZnanja?) -> Unit){
        val serviceAPI = retrofit.create(UrediProvjeruZnanjaApi::class.java)
        serviceAPI.urediProvjeruZnanja(provjeraZnanja).enqueue(
            object : Callback<ProvjeraZnanja> {
                override fun onFailure(call: Call<ProvjeraZnanja>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                    onResult(null)
                }
                override fun onResponse( call: Call<ProvjeraZnanja>, response: Response<ProvjeraZnanja>) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    if (response.isSuccessful) {
                        val uredenaProvjeraZnanja = response.body()
                        onResult(uredenaProvjeraZnanja)
                        Log.d("TAG", "onResponse success: ${response.body()}")
                    }
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

    fun dodajPitanje(pitanje: Pitanje, onResult: (Pitanje?) -> Unit){
        val serviceAPI = retrofit.create(DodajPitanjeApi::class.java)
        serviceAPI.dodajPitanje(pitanje).enqueue(
            object : Callback<Pitanje> {
                override fun onFailure(call: Call<Pitanje>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                    onResult(null)
                }
                override fun onResponse( call: Call<Pitanje>, response: Response<Pitanje>) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    if (response.isSuccessful) {
                        val dodanoPitanje = response.body()
                        onResult(dodanoPitanje)
                        Log.d("TAG", "onResponse success: ${response.body()}")
                    }
                }
            }
        )
    }

    fun obrisiPitanje(pitanjeId: Int, onResult: (Long?) -> Unit) {
        val serviceAPI = retrofit.create(ObrisiPitanjeApi::class.java)
        serviceAPI.obrisiPitanje(pitanjeId).enqueue(
            object : Callback<Long> {
                override fun onFailure(call: Call<Long>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                    onResult(null)
                }

                override fun onResponse(call: Call<Long>, response: Response<Long>) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    if (response.isSuccessful) {
                        val obrisanoPitanje = response.body()
                        onResult(obrisanoPitanje)
                        Log.d("TAG", "onResponse success: ${response.body()}")
                    }
                }
            }
        )
    }

    fun urediPitanje(pitanje: Pitanje, onResult: (Pitanje?) -> Unit){
        val serviceAPI = retrofit.create(UrediPitanjeApi::class.java)
        serviceAPI.urediPitanje(pitanje).enqueue(
            object : Callback<Pitanje> {
                override fun onFailure(call: Call<Pitanje>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                    onResult(null)
                }
                override fun onResponse( call: Call<Pitanje>, response: Response<Pitanje>) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    if (response.isSuccessful) {
                        val uredenoPitanje = response.body()
                        onResult(uredenoPitanje)
                        Log.d("TAG", "onResponse success: ${response.body()}")
                    }
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

    private val _kompetencije = MutableLiveData<List<Kompetencija>>()
    val kompetencije: LiveData<List<Kompetencija>>
        get() = _kompetencije

    fun getKompetencije(programSpecijalizacijeId: Int)
    {
        val serviceAPI = retrofit.create(KompetencijeByProgramSpecijalizacijeIdApi::class.java)
        val call : Call<ArrayList<Kompetencija>> = serviceAPI.getKompetencije(programSpecijalizacijeId)

        call.enqueue (
            object : Callback<ArrayList<Kompetencija>>{
                override fun onResponse(
                    call: Call<ArrayList<Kompetencija>>,
                    response: Response<ArrayList<Kompetencija>>,
                ) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    if (response.isSuccessful) {
                        _kompetencije.value = response.body()
                        Log.d("TAG", "onResponse success: ${response.body()}")
                    }
                }

                override fun onFailure(call: Call<ArrayList<Kompetencija>>, t: Throwable) {
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

    private val _zahvati = MutableLiveData<List<Zahvat>>()
    val zahvati: LiveData<List<Zahvat>>
        get() = _zahvati

    fun getZahvati(programSpecijalizacijeId: Int)
    {
        val serviceAPI = retrofit.create(ZahvatiByProgramSpecijalizacijeApi::class.java)
        val call : Call<ArrayList<Zahvat>> = serviceAPI.getZahvati(programSpecijalizacijeId)

        call.enqueue (
            object : Callback<ArrayList<Zahvat>>{
                override fun onResponse(
                    call: Call<ArrayList<Zahvat>>,
                    response: Response<ArrayList<Zahvat>>,
                ) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    if (response.isSuccessful) {
                        _zahvati.value = response.body()
                        Log.d("TAG", "onResponse success: ${response.body()}")
                    }
                }

                override fun onFailure(call: Call<ArrayList<Zahvat>>, t: Throwable) {
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


    private val _dijelovi = MutableLiveData<List<DioSpecijalizacije>>()
    val dijelovi: LiveData<List<DioSpecijalizacije>>
        get() = _dijelovi

    fun getDijeloviSpecijalizacije(programSpecijalizacijeId: Int)
    {
        val serviceAPI = retrofit.create(DijeloviSpecijalizacijeByProgramSpecijalizacijeApi::class.java)
        val call : Call<ArrayList<DioSpecijalizacije>> = serviceAPI.getDijeloviSpecijalizacije(programSpecijalizacijeId)

        call.enqueue (
            object : Callback<ArrayList<DioSpecijalizacije>>{
                override fun onResponse(
                    call: Call<ArrayList<DioSpecijalizacije>>,
                    response: Response<ArrayList<DioSpecijalizacije>>,
                ) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    if (response.isSuccessful) {
                        _dijelovi.value = response.body()
                        Log.d("TAG", "onResponse success: ${response.body()}")
                    }
                }

                override fun onFailure(call: Call<ArrayList<DioSpecijalizacije>>, t: Throwable) {
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

    fun getUstrojstvenaJedinicaBySpecijalizant(specijlizantId : Int)
    {
        val serviceAPI = retrofit.create(UstrojstvenJedinicaApi::class.java)
        val call : Call<UstrojstvenaJedinica> = serviceAPI.getLokacija(specijlizantId)

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
        val serviceAPI = retrofit.create(OdradeneKompetencijeBySpecijalizacijaIdApi::class.java)
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

    fun dodajOdradenuKompetenciju(odradenaKompetencija: OdradenaKompetencija, onResult: (OdradenaKompetencija?) -> Unit){
        val serviceAPI = retrofit.create(DodajOdradenuKompetencijuApi::class.java)
        serviceAPI.dodajOdradenuKompetenciju(odradenaKompetencija).enqueue(
            object : Callback<OdradenaKompetencija> {
                override fun onFailure(call: Call<OdradenaKompetencija>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                    onResult(null)
                }
                override fun onResponse( call: Call<OdradenaKompetencija>, response: Response<OdradenaKompetencija>) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    if (response.isSuccessful) {
                        val dodanaKompetencija = response.body()
                        onResult(dodanaKompetencija)
                        Log.d("TAG", "onResponse success: ${response.body()}")
                    }
                }
            }
        )
    }

    fun obrisiOdradenuKompetenciju(specijalizacija: Int, kompetencija: Int, stupanj: Int,onResult: (Long?) -> Unit) {
        val serviceAPI = retrofit.create(ObrisiOdradenuKompetencijuApi::class.java)
        serviceAPI.obrisiOdradenuKompetenciju(specijalizacija, kompetencija, stupanj).enqueue(
            object : Callback<Long> {
                override fun onFailure(call: Call<Long>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                    onResult(null)
                }

                override fun onResponse(call: Call<Long>, response: Response<Long>) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    if (response.isSuccessful) {
                        val obrisanaOdradenaKompetencija = response.body()
                        onResult(obrisanaOdradenaKompetencija)
                        Log.d("TAG", "onResponse success: ${response.body()}")
                    }
                }
            }
        )
    }

    fun urediOdradenuKompetenciju(odradenaKompetencija: OdradenaKompetencija, onResult: (OdradenaKompetencija?) -> Unit){
        val serviceAPI = retrofit.create(UrediOdradenuKompetencijuApi::class.java)
        serviceAPI.urediOdradenuKompetenciju(odradenaKompetencija).enqueue(
            object : Callback<OdradenaKompetencija> {
                override fun onFailure(call: Call<OdradenaKompetencija>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                    onResult(null)
                }
                override fun onResponse( call: Call<OdradenaKompetencija>, response: Response<OdradenaKompetencija>) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    if (response.isSuccessful) {
                        val uredenaKompetencija = response.body()
                        onResult(uredenaKompetencija)
                        Log.d("TAG", "onResponse success: ${response.body()}")
                    }
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
        val serviceAPI = retrofit.create(OdradeniZahvatiBySpecijalizacijaIdApi::class.java)
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

    fun dodajOdradeniZahvat(odradeniZahvat: OdradeniZahvat, onResult: (OdradeniZahvat?) -> Unit){
        val serviceAPI = retrofit.create(DodajOdradeniZahvatApi::class.java)
        serviceAPI.dodajOdradeniZahvat(odradeniZahvat).enqueue(
            object : Callback<OdradeniZahvat> {
                override fun onFailure(call: Call<OdradeniZahvat>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                    onResult(null)
                }
                override fun onResponse( call: Call<OdradeniZahvat>, response: Response<OdradeniZahvat>) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    if (response.isSuccessful) {
                        val dodanOdradeniZahvat = response.body()
                        onResult(dodanOdradeniZahvat)
                        Log.d("TAG", "onResponse success: ${response.body()}")
                    }
                }
            }
        )
    }

    fun obrisiOdradeniZahvat(specijalizacija: Int, zahvat: Int, stupanj: Int,onResult: (Long?) -> Unit) {
        val serviceAPI = retrofit.create(ObrisiOdradeniZahvatApi::class.java)
        serviceAPI.obrisiOdradeniZahvat(specijalizacija, zahvat, stupanj).enqueue(
            object : Callback<Long> {
                override fun onFailure(call: Call<Long>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                    onResult(null)
                }

                override fun onResponse(call: Call<Long>, response: Response<Long>) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    if (response.isSuccessful) {
                        val obrisaniOdradeniZahvat = response.body()
                        onResult(obrisaniOdradeniZahvat)
                        Log.d("TAG", "onResponse success: ${response.body()}")
                    }
                }
            }
        )
    }

    fun urediOdradeniZahvat(odradeniZahvat: OdradeniZahvat, onResult: (OdradeniZahvat?) -> Unit){
        val serviceAPI = retrofit.create(UrediOdradeniZahvatApi::class.java)
        serviceAPI.urediOdradeniZahvat(odradeniZahvat).enqueue(
            object : Callback<OdradeniZahvat> {
                override fun onFailure(call: Call<OdradeniZahvat>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                    onResult(null)
                }
                override fun onResponse( call: Call<OdradeniZahvat>, response: Response<OdradeniZahvat>) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    if (response.isSuccessful) {
                        val uredenOdradeniZahvat = response.body()
                        onResult(uredenOdradeniZahvat)
                        Log.d("TAG", "onResponse success: ${response.body()}")
                    }
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
        val serviceAPI = retrofit.create(OdradeniDijeloviSpecijalizacijeBySpecijalizacijaIdApi::class.java)
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

    fun dodajOdradeniDioSpecijalizacije(odradeniDioSpecijalizacije: OdradeniDioSpecijalizacije, onResult: (OdradeniDioSpecijalizacije?) -> Unit){
        val serviceAPI = retrofit.create(DodajOdradeniDioSpecijalizacijeApi::class.java)
        serviceAPI.dodajOdradeniDioSpecijalizacije(odradeniDioSpecijalizacije).enqueue(
            object : Callback<OdradeniDioSpecijalizacije> {
                override fun onFailure(call: Call<OdradeniDioSpecijalizacije>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                    onResult(null)
                }
                override fun onResponse( call: Call<OdradeniDioSpecijalizacije>, response: Response<OdradeniDioSpecijalizacije>) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    if (response.isSuccessful) {
                        val dodanDioSpecijalizacije = response.body()
                        onResult(dodanDioSpecijalizacije)
                        Log.d("TAG", "onResponse success: ${response.body()}")
                    }
                }
            }
        )
    }

    fun obrisiOdradeniDioSpecijalizacije(specijalizacija: Int, dioSpecijalizacije: Int, onResult: (Long?) -> Unit) {
        val serviceAPI = retrofit.create(ObrisiOdradeniDioSpecijalizacijeApi::class.java)
        serviceAPI.obrisiOdradeniDioSpecijalizacije(specijalizacija, dioSpecijalizacije).enqueue(
            object : Callback<Long> {
                override fun onFailure(call: Call<Long>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                    onResult(null)
                }

                override fun onResponse(call: Call<Long>, response: Response<Long>) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    if (response.isSuccessful) {
                        val obrisaniOdradeniDioSpecijalizacije = response.body()
                        onResult(obrisaniOdradeniDioSpecijalizacije)
                        Log.d("TAG", "onResponse success: ${response.body()}")
                    }
                }
            }
        )
    }

    fun urediOdradeniDioSpecijalizacije(odradeniDioSpecijalizacije: OdradeniDioSpecijalizacije, onResult: (OdradeniDioSpecijalizacije?) -> Unit){
        val serviceAPI = retrofit.create(UrediOdradeniDioSpecijalizacijeApi::class.java)
        serviceAPI.urediOdradeniDioSpecijalizacije(odradeniDioSpecijalizacije).enqueue(
            object : Callback<OdradeniDioSpecijalizacije> {
                override fun onFailure(call: Call<OdradeniDioSpecijalizacije>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                    onResult(null)
                }
                override fun onResponse( call: Call<OdradeniDioSpecijalizacije>, response: Response<OdradeniDioSpecijalizacije>) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    if (response.isSuccessful) {
                        val uredeniDioSpecijalizacije = response.body()
                        onResult(uredeniDioSpecijalizacije)
                        Log.d("TAG", "onResponse success: ${response.body()}")
                    }
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

    //Ispit
    private val _ispiti = MutableLiveData<List<Ispit>>()
    val ispiti: LiveData<List<Ispit>>
        get() = _ispiti

    fun getAllIspiti(specijalizacijaId : Int)
    {
        val serviceAPI = retrofit.create(IspitiBySpecijalizacijaIdApi::class.java)
        val call : Call<ArrayList<Ispit>> = serviceAPI.getIspiti(specijalizacijaId)

        call.enqueue (
            object : Callback<ArrayList<Ispit>>{
                override fun onResponse(
                    call: Call<ArrayList<Ispit>>,
                    response: Response<ArrayList<Ispit>>,
                ) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    if (response.isSuccessful) {
                        _ispiti.value = response.body()
                        Log.d("TAG", "onResponse success: ${response.body()}")
                    }
                }

                override fun onFailure(call: Call<ArrayList<Ispit>>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                }
            }
        )
    }

    private val _nadolazeciIspiti = MutableLiveData<List<Ispit>>()
    val nadolazeciIspiti: LiveData<List<Ispit>>
        get() = _nadolazeciIspiti

    fun getNadolazeciIspiti(specijalizacijaId : Int)
    {
        val serviceAPI = retrofit.create(NadolazeciIspitiBySpecijalizacijaApi::class.java)
        val call : Call<ArrayList<Ispit>> = serviceAPI.getIspiti(specijalizacijaId)

        call.enqueue (
            object : Callback<ArrayList<Ispit>>{
                override fun onResponse(
                    call: Call<ArrayList<Ispit>>,
                    response: Response<ArrayList<Ispit>>,
                ) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    if (response.isSuccessful) {
                        _nadolazeciIspiti.value = response.body()
                        Log.d("TAG", "onResponse success: ${response.body()}")
                    }
                }

                override fun onFailure(call: Call<ArrayList<Ispit>>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                }
            }
        )
    }

    fun dodajIspit(ispit: Ispit, onResult: (Ispit?) -> Unit){
        val serviceAPI = retrofit.create(DodajIspitApi::class.java)
        serviceAPI.dodajIspit(ispit).enqueue(
            object : Callback<Ispit> {
                override fun onFailure(call: Call<Ispit>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                    onResult(null)
                }
                override fun onResponse( call: Call<Ispit>, response: Response<Ispit>) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    if (response.isSuccessful) {
                        val dodanIspit = response.body()
                        onResult(dodanIspit)
                        Log.d("TAG", "onResponse success: ${response.body()}")
                    }
                }
            }
        )
    }

    fun urediIspit(ispit: Ispit, onResult: (Ispit?) -> Unit){
        val serviceAPI = retrofit.create(UrediIspitApi::class.java)
        serviceAPI.urediIspit(ispit).enqueue(
            object : Callback<Ispit> {
                override fun onFailure(call: Call<Ispit>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                    onResult(null)
                }
                override fun onResponse( call: Call<Ispit>, response: Response<Ispit>) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    if (response.isSuccessful) {
                        val uredenIspit = response.body()
                        onResult(uredenIspit)
                        Log.d("TAG", "onResponse success: ${response.body()}")
                    }
                }
            }
        )
    }

    fun obrisiIspit(ispitId: Int, onResult: (Long?) -> Unit) {
        val serviceAPI = retrofit.create(ObrisiIspitApi::class.java)
        serviceAPI.obrisiIspit(ispitId).enqueue(
            object : Callback<Long> {
                override fun onFailure(call: Call<Long>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                    onResult(null)
                }

                override fun onResponse(call: Call<Long>, response: Response<Long>) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    if (response.isSuccessful) {
                        val obrisanIspit = response.body()
                        onResult(obrisanIspit)
                        Log.d("TAG", "onResponse success: ${response.body()}")
                    }
                }
            }
        )
    }

    //Prijava
    fun mentorPrijava(prijava: Prijava, onResult: (Mentor?) -> Unit){
        val serviceAPI = retrofit.create(MentorPrijavaApi::class.java)
        serviceAPI.mentorPrijava(prijava).enqueue(
            object : Callback<Mentor> {
                override fun onFailure(call: Call<Mentor>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                    onResult(null)
                }
                override fun onResponse( call: Call<Mentor>, response: Response<Mentor>) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    if (response.isSuccessful) {
                        val dodanIspit = response.body()
                        onResult(dodanIspit)
                        Log.d("TAG", "onResponse success: ${response.body()}")
                    }
                }
            }
        )
    }

    fun specijalizantPrijava(prijava: Prijava, onResult: (Specijalizant?) -> Unit){
        val serviceAPI = retrofit.create(SpecijalizantPrijavaApi::class.java)
        serviceAPI.specijalizantPrijava(prijava).enqueue(
            object : Callback<Specijalizant> {
                override fun onFailure(call: Call<Specijalizant>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                    onResult(null)
                }
                override fun onResponse( call: Call<Specijalizant>, response: Response<Specijalizant>) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    if (response.isSuccessful) {
                        val dodanIspit = response.body()
                        onResult(dodanIspit)
                        Log.d("TAG", "onResponse success: ${response.body()}")
                    }
                }
            }
        )
    }
}
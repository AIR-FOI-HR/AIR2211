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

    fun dodajSpecijlizaciju(specijalizacija: Specijalizacija, onResult: (Specijalizacija?) -> Unit){
        val serviceAPI = retrofit.create(NovaSpecijalizacijaApi::class.java)
        serviceAPI.dodajSpecijlizaciju(specijalizacija).enqueue(
            object : Callback<Specijalizacija> {
                override fun onFailure(call: Call<Specijalizacija>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                    onResult(null)
                }
                override fun onResponse( call: Call<Specijalizacija>, response: Response<Specijalizacija>) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    if (response.isSuccessful) {
                        val dodanaSpecijlizacija = response.body()
                        onResult(dodanaSpecijlizacija)
                        Log.d("TAG", "onResponse success: ${response.body()}")
                    }
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
        val serviceAPI = retrofit.create(DodajSlucjaBolesnikaApi::class.java)
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
        val serviceAPI = retrofit.create(ProvjeraZnanjaById::class.java)
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

    fun dodajOdradenuKompetenciju(odradenaKompetencija: OdradenaKompetencija, onResult: (OdradenaKompetencija?) -> Unit){
        val serviceAPI = retrofit.create(DodajKompetencijuApi::class.java)
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

    fun dodajOdredeniZahvat(odradeniZahvat: OdradeniZahvat, onResult: (OdradeniZahvat?) -> Unit){
        val serviceAPI = retrofit.create(DodajZahvatApi::class.java)
        serviceAPI.dodajZahvat(odradeniZahvat).enqueue(
            object : Callback<OdradeniZahvat> {
                override fun onFailure(call: Call<OdradeniZahvat>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.message}")
                    onResult(null)
                }
                override fun onResponse( call: Call<OdradeniZahvat>, response: Response<OdradeniZahvat>) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    if (response.isSuccessful) {
                        val dodanZahvat = response.body()
                        onResult(dodanZahvat)
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

    fun dodajOdradeniDioSpecijalizacije(odradeniDioSpecijalizacije: OdradeniDioSpecijalizacije, onResult: (OdradeniDioSpecijalizacije?) -> Unit){
        val serviceAPI = retrofit.create(DodajOdradeniDioSpecijalizacije::class.java)
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
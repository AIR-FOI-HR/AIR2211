package hr.foi.air.ednevnik.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.ws.WebServis
import hr.foi.air.ednevnik.MainActivity
import hr.foi.air.ednevnik.R
import hr.foi.air.ednevnik.databinding.SpecijalizantPracenjeSpecijalizacijeBinding

class SpecijalizantPracenjeSpecijalizacije : Fragment() {
    private var _binding: SpecijalizantPracenjeSpecijalizacijeBinding? = null
    private val binding: SpecijalizantPracenjeSpecijalizacijeBinding
        get() = _binding!!

    private lateinit var webServis: WebServis

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SpecijalizantPracenjeSpecijalizacijeBinding.inflate(inflater, container, false)

        var gumbSlucajBolesnika = _binding!!.slucajBolesnika

        gumbSlucajBolesnika.setOnClickListener() {
            Log.d("PracnjeTAG", webServis.specijalizacija.value.toString())
            val action = SpecijalizantPracenjeSpecijalizacijeDirections.actionSpecijalizantPracenjeSpecijlizacijeToSpecijalizantSlucajeviBolesnika(webServis.specijalizacija.value!!.id_specijalizacija.toString())
            this.findNavController().navigate(action)
        }

        var gumbStrucniRad = _binding!!.strucniRad
        gumbStrucniRad.setOnClickListener() {
            Log.d("PracnjeTAG", webServis.specijalizacija.value.toString())
            val action = SpecijalizantPracenjeSpecijalizacijeDirections.actionSpecijalizantPracenjeSpecijlizacijeToSpecijlizantStrucniRadovi(webServis.specijalizacija.value!!.id_specijalizacija.toString())
            this.findNavController().navigate(action)
        }

        var gumbDnevnaAktivnost = _binding!!.dnevnaAktivnost

        gumbDnevnaAktivnost.setOnClickListener() {
            Log.d("PracnjeTAG", webServis.specijalizacija.value.toString())
            val action = SpecijalizantPracenjeSpecijalizacijeDirections.actionSpecijalizantPracenjeSpecijlizacijeToSpecijalizantDnevneAktivnosti(webServis.specijalizacija.value!!.id_specijalizacija.toString())
            this.findNavController().navigate(action)
        }

        var gumbProvjeraZnanja = _binding!!.provjeraZnanja

        gumbProvjeraZnanja.setOnClickListener() {
            Log.d("PracnjeTAG", webServis.specijalizacija.value.toString())
            val action = SpecijalizantPracenjeSpecijalizacijeDirections.actionSpecijalizantPracenjeSpecijalizacijeToSpecijalizantProvjereZnanja(webServis.specijalizacija.value!!.id_specijalizacija.toString())
            this.findNavController().navigate(action)
        }

        var gumbOdradeneKompetencije = _binding!!.kompetencija

        gumbOdradeneKompetencije.setOnClickListener() {
            Log.d("PracnjeTAG", webServis.specijalizacija.value.toString())
            val action = SpecijalizantPracenjeSpecijalizacijeDirections.actionSpecijalizantPracenjeSpecijlizacijeToSpecijalizantKompetencije(webServis.specijalizacija.value!!.id_specijalizacija.toString())
            this.findNavController().navigate(action)
        }

        var gumbOdradeniZahvati = _binding!!.zahvat

        gumbOdradeniZahvati.setOnClickListener() {
            Log.d("PracnjeTAG", webServis.specijalizacija.value.toString())
            val action = SpecijalizantPracenjeSpecijalizacijeDirections.actionSpecijalizantPracenjeSpecijlizacijeToSpecijalizantZahvati(webServis.specijalizacija.value!!.id_specijalizacija.toString())
            this.findNavController().navigate(action)
        }

        var gumbOdradeniDijeloviSpecijalizacije = _binding!!.dioSpecijalizacije

        gumbOdradeniDijeloviSpecijalizacije.setOnClickListener() {
            Log.d("PracnjeTAG", webServis.specijalizacija.value.toString())
            val action = SpecijalizantPracenjeSpecijalizacijeDirections.actionSpecijalizantPracenjeSpecijlizacijeToSpecijalizantDioSpecijalizacije(webServis.specijalizacija.value!!.id_specijalizacija.toString())
            this.findNavController().navigate(action)
        }

        var gumbIspiti = _binding!!.ispiti

        gumbIspiti.setOnClickListener() {
            Log.d("PracnjeTAG", webServis.specijalizacija.value.toString())
            val action = SpecijalizantPracenjeSpecijalizacijeDirections.actionSpecijalizantPracenjeSpecijalizacijeToSpecijalizantIspiti(webServis.specijalizacija.value!!.id_specijalizacija.toString())
            this.findNavController().navigate(action)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        webServis = WebServis()

        MainActivity.homeAction = R.id.action_global_specijalizantPracenjeSpecijalizacije

        webServis.getSpecijalizacija(MainActivity.specijalizant?.id_specijalizant!!)

        webServis.specijalizacija.observe(viewLifecycleOwner) {
            webServis.getBrojUvjeta(webServis.specijalizacija.value?.programSpecijalizacijeId!!)
            webServis.getAllOdradeniZahvati(webServis.specijalizacija.value?.id_specijalizacija!!)
            webServis.getAllOdradeniDijeloviSpecijalizacije(webServis.specijalizacija.value?.id_specijalizacija!!)
            webServis.getAllOdradeneKompetencije(webServis.specijalizacija.value?.id_specijalizacija!!)
        }

        val progressBar = _binding!!.napredakSpecijalizacije
        var rijeseno = 0

        webServis.brojUvjeta.observe(viewLifecycleOwner) {
            progressBar.max = webServis.brojUvjeta.value!!
        }
        webServis.odradeniZahvati.observe(viewLifecycleOwner) {
            rijeseno += webServis.odradeniZahvati.value!!.count()
            _binding!!.napredakZahvati.text = "Zahvati: ${webServis.odradeniZahvati.value!!.count()}"
            progressBar.progress = rijeseno
        }
        webServis.odradeniDijeloviSpecijalizacije.observe(viewLifecycleOwner) {
            rijeseno += webServis.odradeniDijeloviSpecijalizacije.value!!.count()
            _binding!!.napredakDioSpec.text = "Dijelovi specijalizacije: ${webServis.odradeniDijeloviSpecijalizacije.value!!.count()}"
            progressBar.progress = rijeseno
        }
        webServis.odradeneKompetencije.observe(viewLifecycleOwner) {
            rijeseno += webServis.odradeneKompetencije.value!!.count()
            _binding!!.napredakKompetencije.text = "Kompetencije: ${webServis.odradeneKompetencije.value!!.count()}"
            progressBar.progress = rijeseno
        }

        progressBar.progress = rijeseno
    }
}
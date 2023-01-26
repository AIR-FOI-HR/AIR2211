package hr.foi.air.ednevnik.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.core.entities.OdradenaKompetencija
import com.example.ws.WebServis
import hr.foi.air.ednevnik.databinding.SpecijalizantDodajOdradenuKompetencijuBinding
import java.text.SimpleDateFormat
import java.util.*

class UnosOdradeneKompetencije : Fragment() {
    private val args: UnosOdradeneKompetencijeArgs by navArgs<UnosOdradeneKompetencijeArgs>()
    private var _binding: SpecijalizantDodajOdradenuKompetencijuBinding? = null
    private val binding: SpecijalizantDodajOdradenuKompetencijuBinding
        get() = _binding!!

    lateinit var webServis: WebServis

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = SpecijalizantDodajOdradenuKompetencijuBinding.inflate(inflater, container, false)

        val datePicker = _binding!!.datePicker
        datePicker.updateDate(2023, 0, 1)
        var unesenaOdradenaKompetencija = args.argOdradenaKompetencija
        var uredi = false
        if(unesenaOdradenaKompetencija!=null)
        {
            uredi = true
            var godina = unesenaOdradenaKompetencija.datum!!.split("-")[0].toInt()
            var mjesec = unesenaOdradenaKompetencija.datum!!.split("-")[1].toInt()
            var dan = unesenaOdradenaKompetencija.datum!!.split("-")[2].toInt()
            datePicker.updateDate(godina, mjesec - 1, dan)
            _binding!!.inputStupanjKompetencije.editText?.setText(unesenaOdradenaKompetencija.stupanj!!.toString())
            _binding!!.inputBrojKompetencije.editText?.setText(unesenaOdradenaKompetencija.kompetencija!!.toString())
            _binding!!.inputStupanjKompetencije.setVisibility(View.GONE)
            _binding!!.inputBrojKompetencije.setVisibility(View.GONE)
        }


        _binding!!.gumbPotvrdi.setOnClickListener {
            val godina = datePicker.year - 1900
            val mjesec = datePicker.month
            val dan = datePicker.dayOfMonth
            val datum = Date(godina, mjesec, dan)
            val formatter = SimpleDateFormat("yyyy-MM-dd")
            val current = formatter.format(datum)
            val brojKompetencije = _binding!!.inputBrojKompetencije.editText?.text.toString().toInt()
            val stupanj = _binding!!.inputStupanjKompetencije.editText?.text.toString().toInt()
            val idSpecijlizacije = args.argSpecijalizacijaId.toInt()

            val odradenaKompetencija = OdradenaKompetencija(idSpecijlizacije, brojKompetencije, stupanj, current, null)

            if(uredi==false){
                webServis.dodajOdradenuKompetenciju(odradenaKompetencija) {
                }
            } else{
                if(unesenaOdradenaKompetencija!!.potpisMentora!=null) { odradenaKompetencija.potpisMentora = unesenaOdradenaKompetencija!!.potpisMentora }
                webServis.urediOdradenuKompetenciju(odradenaKompetencija) {
                }
            }

            val action =
                UnosOdradeneKompetencijeDirections.actionUnosOdradeneKompetencijeToSpecijalizantPracenjeSpecijlizacije()
            this.findNavController().navigate(action)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        webServis = WebServis()
    }
}
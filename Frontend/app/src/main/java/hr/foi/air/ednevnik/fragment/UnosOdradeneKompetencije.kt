package hr.foi.air.ednevnik.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.core.entities.OdradenaKompetencija
import com.example.core.entities.OdradeniZahvat
import com.example.ws.WebServis
import hr.foi.air.ednevnik.databinding.SpecijalizantDodajOdradenuKompetencijuBinding
import hr.foi.air.ednevnik.databinding.SpecijalizantDodajZahvatBinding
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


        _binding!!.gumbPotvrdiSlucajBolesnika.setOnClickListener {
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

            webServis.dodajOdradenuKompetenciju(odradenaKompetencija) {

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
package hr.foi.air.ednevnik.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.core.entities.OdradenaKompetencija
import com.example.core.entities.OdradeniDioSpecijalizacije
import com.example.ws.WebServis
import hr.foi.air.ednevnik.databinding.SpecijalizantDodajOdradeniDioSpecijalizacijeBinding
import hr.foi.air.ednevnik.databinding.SpecijalizantDodajOdradenuKompetencijuBinding
import java.text.SimpleDateFormat
import java.util.*

class UnosOdradenogDijelaSpecijalizacije : Fragment() {
    private val args: UnosOdradenogDijelaSpecijalizacijeArgs by navArgs<UnosOdradenogDijelaSpecijalizacijeArgs>()
    private var _binding: SpecijalizantDodajOdradeniDioSpecijalizacijeBinding? = null
    private val binding: SpecijalizantDodajOdradeniDioSpecijalizacijeBinding
        get() = _binding!!

    lateinit var webServis: WebServis

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = SpecijalizantDodajOdradeniDioSpecijalizacijeBinding.inflate(inflater, container, false)

        val datePicker = _binding!!.datePicker
        datePicker.updateDate(2023, 0, 1)


        _binding!!.gumbPotvrdiSlucajBolesnika.setOnClickListener {
            val godina = datePicker.year - 1900
            val mjesec = datePicker.month
            val dan = datePicker.dayOfMonth
            val datum = Date(godina, mjesec, dan)
            val formatter = SimpleDateFormat("yyyy-MM-dd")
            val current = formatter.format(datum)
            val brojDioSpecijalizacija = _binding!!.inputDioSpecijalizacije.editText?.text.toString().toInt()
            val idSpecijlizacije = args.argSpecijalizacijaId.toInt()

            val odradeniDioSpecijalizacije = OdradeniDioSpecijalizacije(idSpecijlizacije, brojDioSpecijalizacija, 1, null, null, current, null)

            webServis.dodajOdradeniDioSpecijalizacije(odradeniDioSpecijalizacije) {

            }

            val action = UnosOdradenogDijelaSpecijalizacijeDirections.actionUnosOdradenogDijelaSpecijalizacijeToSpecijalizantPracenjeSpecijlizacije()
            this.findNavController().navigate(action)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        webServis = WebServis()
    }
}
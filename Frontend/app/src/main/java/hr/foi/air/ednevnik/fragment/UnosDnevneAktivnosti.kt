package hr.foi.air.ednevnik.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.core.entities.DnevnaAktivnost
import com.example.core.entities.SlucajBolesnika
import com.example.ws.WebServis
import hr.foi.air.ednevnik.databinding.SpecijalizantDodajDnevnuAktivnostBinding
import hr.foi.air.ednevnik.databinding.SpecijalizantDodajSlucajBolesnikaBinding
import java.text.SimpleDateFormat
import java.util.*

class UnosDnevneAktivnosti : Fragment() {
    private val args : UnosDnevneAktivnostiArgs by navArgs<UnosDnevneAktivnostiArgs>()
    private var _binding: SpecijalizantDodajDnevnuAktivnostBinding? = null
    private val binding: SpecijalizantDodajDnevnuAktivnostBinding
        get() = _binding!!

    lateinit var webServis: WebServis

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = SpecijalizantDodajDnevnuAktivnostBinding.inflate(inflater, container, false)

        val datePicker = _binding!!.datePicker
        datePicker.updateDate(2023, 0, 1)


        _binding!!.gumbPotvrdiSlucajBolesnika.setOnClickListener {
            val godina = datePicker.year - 1900
            val mjesec = datePicker.month
            val dan = datePicker.dayOfMonth
            val datum = Date(godina, mjesec, dan)
            val formatter = SimpleDateFormat("yyyy-MM-dd")
            val current = formatter.format(datum)
            val naziv = _binding!!.inputNazivAktivnosti.editText?.text.toString()
            val opis = _binding!!.inputNazivAktivnosti.editText?.text.toString()
            val brojZahvataNadzor = _binding!!.inputBrojZahvataNadzor.editText?.text.toString().toInt()
            val brojZahvataSamostalno = _binding!!.inputBrojZahvataSamostalno.editText?.text.toString().toInt()
            val idSpecijlizacije = args.argSpecijalizacijaId.toInt()

            val dnevnaAktivnost = DnevnaAktivnost(null, idSpecijlizacije, current, naziv, opis, brojZahvataNadzor, brojZahvataSamostalno, null)

            webServis.dodajDnevnuAktivnost(dnevnaAktivnost) {

            }

            val action = UnosDnevneAktivnostiDirections.actionUnosDnevneAktivnostiToSpecijalizantPracenjeSpecijlizacije()
            this.findNavController().navigate(action)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        webServis = WebServis()
    }
}
package hr.foi.air.ednevnik.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.core.entities.ProvjeraZnanja
import com.example.ws.WebServis
import hr.foi.air.ednevnik.databinding.SpecijalizantDodajProvjeruZnanjaBinding
import java.text.SimpleDateFormat
import java.util.*

class UnosProvjereZnanja : Fragment() {
    private val args : UnosProvjereZnanjaArgs by navArgs<UnosProvjereZnanjaArgs>()
    private var _binding: SpecijalizantDodajProvjeruZnanjaBinding? = null
    private val binding: SpecijalizantDodajProvjeruZnanjaBinding
        get() = _binding!!

    lateinit var webServis: WebServis

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = SpecijalizantDodajProvjeruZnanjaBinding.inflate(inflater, container, false)

        val datePicker = _binding!!.datePicker
        datePicker.updateDate(2023, 0, 1)


        _binding!!.gumbPotvrdiProvjeruZnanja.setOnClickListener {
            val godina = datePicker.year - 1900
            val mjesec = datePicker.month
            val dan = datePicker.dayOfMonth
            val datum = Date(godina, mjesec, dan)
            val formatter = SimpleDateFormat("yyyy-MM-dd")
            val current = formatter.format(datum)
            var ocjena : Int?
            if(_binding!!.inputOcjenaProvjere.editText?.text.toString()!="") {
                ocjena = _binding!!.inputOcjenaProvjere.editText?.text.toString().toInt()
            }else{
                ocjena = null
            }
            Log.d("TAG", args.argSpecijalizacijaId)
            val idSpecijlizacije = args.argSpecijalizacijaId.toInt()

            val provjeraZnanja = ProvjeraZnanja(null, idSpecijlizacije, current, ocjena, null)

            webServis.dodajProvjeruZnanja(provjeraZnanja) {

            }

            val action = UnosProvjereZnanjaDirections.actionUnosProvjereZnanjaToSpecijalizantPracenjeSpecijalizacije()
            this.findNavController().navigate(action)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        webServis = WebServis()
    }
}
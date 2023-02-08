package hr.foi.air.ednevnik.fragment

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.core.entities.ProvjeraZnanja
import com.example.ws.WebServis
import hr.foi.air.ednevnik.R
import hr.foi.air.ednevnik.databinding.SpecijalizantDodajProvjeruZnanjaBinding
import java.text.SimpleDateFormat
import java.util.*

class UnosProvjereZnanja : Fragment() {
    private val args : UnosProvjereZnanjaArgs by navArgs<UnosProvjereZnanjaArgs>()
    private var _binding: SpecijalizantDodajProvjeruZnanjaBinding? = null
    private val binding: SpecijalizantDodajProvjeruZnanjaBinding
        get() = _binding!!

    lateinit var webServis: WebServis
    val ocjene = listOf<Int>(0, 1, 2, 3, 4, 5)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = SpecijalizantDodajProvjeruZnanjaBinding.inflate(inflater, container, false)

        val adapter = ArrayAdapter(requireContext(), R.layout.list_item, ocjene)
        _binding!!.spinner.setAdapter(adapter)

        val datePicker = _binding!!.datePicker
        datePicker.updateDate(2023, 0, 1)
        var unesenaProvjeraZnanja = args.argProvjeraZnanja
        var uredi = false
        if(unesenaProvjeraZnanja!=null)
        {
            uredi = true
            var godina = unesenaProvjeraZnanja.datumProvjera!!.split("-")[0].toInt()
            var mjesec = unesenaProvjeraZnanja.datumProvjera!!.split("-")[1].toInt()
            var dan = unesenaProvjeraZnanja.datumProvjera!!.split("-")[2].toInt()
            datePicker.updateDate(godina, mjesec - 1, dan)
            if(unesenaProvjeraZnanja.ocjenaProvjera!=null) { _binding!!.spinner.setText(unesenaProvjeraZnanja.ocjenaProvjera.toString()) }
        }

        _binding!!.spinner.setOnClickListener{
            _binding!!.spinner.setText("")
            _binding!!.spinner.setOnClickListener{

            }
        }


        _binding!!.gumbPotvrdiProvjeruZnanja.setOnClickListener {
            val godina = datePicker.year - 1900
            val mjesec = datePicker.month
            val dan = datePicker.dayOfMonth
            val datum = Date(godina, mjesec, dan)
            val formatter = SimpleDateFormat("yyyy-MM-dd")
            val current = formatter.format(datum)
            var ocjena : Int?
            if(_binding!!.spinner.text?.toString()!=""){
                if(_binding!!.spinner.text?.toString()?.toInt()!=0)
                {
                    ocjena = _binding!!.spinner.text?.toString()?.toInt()
                }else{
                    ocjena = null
                }
            }else{
                ocjena = null
            }
            Log.d("TAG", args.argSpecijalizacijaId)
            val idSpecijlizacije = args.argSpecijalizacijaId.toInt()

            val provjeraZnanja = ProvjeraZnanja(null, idSpecijlizacije, current, ocjena, null)



            if(uredi==false){
                webServis.dodajProvjeruZnanja(provjeraZnanja) {
                }
            } else{
                if(unesenaProvjeraZnanja!!.potpisMentora!=null) { provjeraZnanja.potpisMentora = unesenaProvjeraZnanja!!.potpisMentora }
                provjeraZnanja.idProvjera = unesenaProvjeraZnanja.idProvjera
                webServis.urediProvjeruZnanja(provjeraZnanja) {
                }
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
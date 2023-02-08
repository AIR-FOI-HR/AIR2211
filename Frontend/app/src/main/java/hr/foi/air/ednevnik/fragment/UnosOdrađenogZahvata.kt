package hr.foi.air.ednevnik.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.core.entities.Kompetencija
import com.example.core.entities.OdradeniZahvat
import com.example.core.entities.Zahvat
import com.example.ws.WebServis
import hr.foi.air.ednevnik.R
import hr.foi.air.ednevnik.databinding.SpecijalizantDodajZahvatBinding
import java.text.SimpleDateFormat
import java.util.*

class UnosOdrađenogZahvata : Fragment() {
    private val args : UnosOdrađenogZahvataArgs by navArgs<UnosOdrađenogZahvataArgs>()
    private var _binding: SpecijalizantDodajZahvatBinding? = null
    private val binding: SpecijalizantDodajZahvatBinding
        get() = _binding!!

    lateinit var webServis: WebServis
    val stupnjevi = listOf<Int>(1, 2, 3)
    var kompetencije = ArrayList<Zahvat>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = SpecijalizantDodajZahvatBinding.inflate(inflater, container, false)

        val adapter = ArrayAdapter(requireContext(), R.layout.list_item, stupnjevi)
        _binding!!.spinner.setAdapter(adapter)

        webServis = WebServis()
        webServis.zahvati.observe(viewLifecycleOwner) {
            it.forEach {
                kompetencije.add(it)
            }

            val adapterZahvati = ArrayAdapter(requireContext(), R.layout.list_item, kompetencije)
            _binding!!.spinnerZahvat.setAdapter(adapterZahvati)

            val datePicker = _binding!!.datePicker
            datePicker.updateDate(2023, 0, 1)
            var uneseniOdradeniZahvat = args.argOdradeniZahvat
            var uredi = false
            if(uneseniOdradeniZahvat!=null)
            {
                uredi = true
                var godina = uneseniOdradeniZahvat.datum!!.split("-")[0].toInt()
                var mjesec = uneseniOdradeniZahvat.datum!!.split("-")[1].toInt()
                var dan = uneseniOdradeniZahvat.datum!!.split("-")[2].toInt()
                datePicker.updateDate(godina, mjesec - 1, dan)
                _binding!!.inputStupanj.editText?.setText(uneseniOdradeniZahvat.stupanj!!.toString())
                _binding!!.inputBrojZahvat.editText?.setText(uneseniOdradeniZahvat.zahvat!!.toString())
                _binding!!.inputStupanj.setVisibility(View.GONE)
                _binding!!.inputBrojZahvat.setVisibility(View.GONE)
            }


            _binding!!.gumbPotvrdi.setOnClickListener {
                val godina = datePicker.year - 1900
                val mjesec = datePicker.month
                val dan = datePicker.dayOfMonth
                val datum = Date(godina, mjesec, dan)
                val formatter = SimpleDateFormat("yyyy-MM-dd")
                val current = formatter.format(datum)
                val brojZahvata = _binding!!.spinnerZahvat.text?.toString()!!.split(" - ")[0].toInt()
                val stupanj = _binding!!.spinner.text?.toString()?.toInt()
                val idSpecijlizacije = args.argSpecijalizacijaId.toInt()

                val odradeniZahvat = OdradeniZahvat(idSpecijlizacije, brojZahvata, stupanj, current, null)

                if(uredi==false){
                    webServis.dodajOdradeniZahvat(odradeniZahvat) {
                    }
                } else{
                    if(uneseniOdradeniZahvat!!.potpisMentora!=null) { odradeniZahvat.potpisMentora = uneseniOdradeniZahvat!!.potpisMentora }
                    webServis.urediOdradeniZahvat(odradeniZahvat) {
                    }
                }

                val action = UnosOdrađenogZahvataDirections.actionUnosOdrađenogZahvataToSpecijalizantPracenjeSpecijlizacije()
                this.findNavController().navigate(action)
            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        webServis.getSpecijalizacijaById(args.argSpecijalizacijaId.toInt())
        webServis.specijalizacija.observe(viewLifecycleOwner){
            webServis.getZahvati(it.programSpecijalizacijeId!!.toInt())
        }

    }
}
package hr.foi.air.ednevnik.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.core.entities.SlucajBolesnika
import com.example.core.entities.Specijalizacija
import com.example.ws.WebServis
import hr.foi.air.ednevnik.databinding.MentorUnosParametaraSpecijalizacijeBinding
import hr.foi.air.ednevnik.databinding.SpecijalizantDodajSlucajBolesnikaBinding
import java.text.SimpleDateFormat
import java.util.*

class UnosSlucajaBolesnika : Fragment() {
    private val args : UnosSlucajaBolesnikaArgs by navArgs<UnosSlucajaBolesnikaArgs>()
    private var _binding: SpecijalizantDodajSlucajBolesnikaBinding? = null
    private val binding: SpecijalizantDodajSlucajBolesnikaBinding
        get() = _binding!!

    lateinit var webServis: WebServis

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = SpecijalizantDodajSlucajBolesnikaBinding.inflate(inflater, container, false)

        val datePicker = _binding!!.datePicker
        datePicker.updateDate(2023, 0, 1)
        var unesenSlucajBolesnika = args.argSlucajBolesnika
        var uredi = false
        if(unesenSlucajBolesnika!=null)
        {
            uredi = true
            var godina = unesenSlucajBolesnika.datumSlucaj!!.split("-")[0].toInt()
            var mjesec = unesenSlucajBolesnika.datumSlucaj!!.split("-")[1].toInt()
            var dan = unesenSlucajBolesnika.datumSlucaj!!.split("-")[2].toInt()
            datePicker.updateDate(godina, mjesec - 1, dan)
            if(unesenSlucajBolesnika.opisSlucaj!=null) { _binding!!.inputOpisSlucaja.editText?.setText(unesenSlucajBolesnika.opisSlucaj) }
            if(unesenSlucajBolesnika.dijagnozaSlucaj!=null) { _binding!!.inputDijagnoza.editText?.setText(unesenSlucajBolesnika.dijagnozaSlucaj) }
        }


        _binding!!.gumbPotvrdi.setOnClickListener {
            val godina = datePicker.year - 1900
            val mjesec = datePicker.month
            val dan = datePicker.dayOfMonth
            val datum = Date(godina, mjesec, dan)
            val formatter = SimpleDateFormat("yyyy-MM-dd")
            val current = formatter.format(datum)
            val opis = _binding!!.inputOpisSlucaja.editText?.text.toString()
            val dijagnoza = _binding!!.inputDijagnoza.editText?.text.toString()
            Log.d("TAG", args.argSpecijalizacijaId)
            val idSpecijlizacije = args.argSpecijalizacijaId.toInt()

            val slucajBolesnika = SlucajBolesnika(null, idSpecijlizacije, current, dijagnoza, opis, null)

            webServis.dodajSlucajBolesnika(slucajBolesnika) {

            }

            if(uredi==false){
                webServis.dodajSlucajBolesnika(slucajBolesnika) {
                }
            } else{
                if(unesenSlucajBolesnika!!.potpisMentora!=null) { slucajBolesnika.potpisMentora = unesenSlucajBolesnika!!.potpisMentora }
                slucajBolesnika.idSlucaj = unesenSlucajBolesnika.idSlucaj
                webServis.urediSlucajBolesnika(slucajBolesnika) {
                }
            }

            val action = UnosSlucajaBolesnikaDirections.actionUnosSlucajaBolesnikaToSpecijalizantPracenjeSpecijlizacije()
            this.findNavController().navigate(action)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        webServis = WebServis()
    }
}
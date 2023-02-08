package hr.foi.air.ednevnik.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.core.entities.Ispit
import com.example.ws.WebServis
import hr.foi.air.ednevnik.databinding.MentorDodajIspitBinding
import java.sql.Time
import java.text.SimpleDateFormat
import java.util.*

class UnosIspita : Fragment() {
    private val args : UnosIspitaArgs by navArgs<UnosIspitaArgs>()
    private var _binding: MentorDodajIspitBinding? = null
    private val binding: MentorDodajIspitBinding
        get() = _binding!!

    lateinit var webServis: WebServis

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = MentorDodajIspitBinding.inflate(inflater, container, false)

        val datePicker = _binding!!.datePicker
        val timePicker = _binding!!.timePicker
        datePicker.updateDate(2023, 0, 1)
        var unesenIspit = args.argIspit
        var uredi = false
        if(unesenIspit!=null)
        {
            uredi = true
            var godina = unesenIspit.datum!!.split("-")[0].toInt()
            var mjesec = unesenIspit.datum!!.split("-")[1].toInt()
            var dan = unesenIspit.datum!!.split("-")[2].toInt()
            datePicker.updateDate(godina, mjesec - 1, dan)
            _binding!!.inputNazivUstanove.editText?.setText(unesenIspit.nazivUstanove)
            if(unesenIspit.prosao=="1") { _binding!!.prosao.isChecked=true }
            else if(unesenIspit.prosao=="0"){ _binding!!.nijeProsao.isChecked=true }
            else{
                _binding!!.prosao.isChecked = false
                _binding!!.nijeProsao.isChecked = false
            }
            var sat = unesenIspit.vrijemeOdrzavanja.split(":")[0].toInt()
            var minuta = unesenIspit.vrijemeOdrzavanja.split(":")[1].toInt()
            timePicker.hour = sat
            timePicker.minute = minuta
        }


        _binding!!.gumbPotvrdiIspit.setOnClickListener {
            val godina = datePicker.year - 1900
            val mjesec = datePicker.month
            val dan = datePicker.dayOfMonth
            val datum = Date(godina, mjesec, dan)
            val formatter = SimpleDateFormat("yyyy-MM-dd")
            val current = formatter.format(datum)
            val ustanova = _binding!!.inputNazivUstanove.editText?.text.toString()
            Log.d("TAG", args.argSpecijalizacijaId)
            val idSpecijlizacije = args.argSpecijalizacijaId.toInt()
            val sat = timePicker.hour
            val minuta = timePicker.minute
            val vrijeme = Time(sat, minuta, 0)
            val formatterTime = SimpleDateFormat("HH:mm:ss")
            val currentTime = formatterTime.format(vrijeme)
            var prosao : String? = null
            if(_binding!!.prosao.isChecked) { prosao = "1"}
            else if(_binding!!.nijeProsao.isChecked) { prosao = "0"}

            val ispit = Ispit(null, idSpecijlizacije, current, currentTime, ustanova, prosao)



            if(uredi==false){
                webServis.dodajIspit(ispit) {
                    this.findNavController().popBackStack()
                }
            } else{
                ispit.idIspit = unesenIspit!!.idIspit
                webServis.urediIspit(ispit) {
                    val action = UnosIspitaDirections.actionUnosIspitaToIspitiFragment(ispit.specijalizacija.toString())
                    this.findNavController().navigate(action)
                }
            }

        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        webServis = WebServis()
    }
}
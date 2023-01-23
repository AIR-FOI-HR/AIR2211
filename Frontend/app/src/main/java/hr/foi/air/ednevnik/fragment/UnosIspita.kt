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

            webServis.dodajIspit(ispit) {
                this.findNavController().popBackStack()
            }

        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        webServis = WebServis()
    }
}
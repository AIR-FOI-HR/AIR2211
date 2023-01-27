package hr.foi.air.ednevnik.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.core.entities.DioSpecijalizacije
import com.example.core.entities.OdradeniDioSpecijalizacije
import com.example.ws.WebServis
import hr.foi.air.ednevnik.R
import hr.foi.air.ednevnik.databinding.SpecijalizantDodajOdradeniDioSpecijalizacijeBinding
import java.text.SimpleDateFormat
import java.util.*

class UnosOdradenogDijelaSpecijalizacije : Fragment() {
    private val args: UnosOdradenogDijelaSpecijalizacijeArgs by navArgs<UnosOdradenogDijelaSpecijalizacijeArgs>()
    private var _binding: SpecijalizantDodajOdradeniDioSpecijalizacijeBinding? = null
    private val binding: SpecijalizantDodajOdradeniDioSpecijalizacijeBinding
        get() = _binding!!

    lateinit var webServis: WebServis
    var dijeloviSpecijalizacije = ArrayList<DioSpecijalizacije>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = SpecijalizantDodajOdradeniDioSpecijalizacijeBinding.inflate(inflater, container, false)

        webServis = WebServis()
        webServis.dijelovi.observe(viewLifecycleOwner) {
            it.forEach {
                dijeloviSpecijalizacije.add(it)
            }

            val adapterDijeloviSpecijalizacije = ArrayAdapter(requireContext(), R.layout.list_item, dijeloviSpecijalizacije)
            _binding!!.spinner.setAdapter(adapterDijeloviSpecijalizacije)

            val datePickerOd = _binding!!.datePickerOd
            datePickerOd.updateDate(2023, 0, 1)
            var uneseniOdradeniDioSpecijalizacije = args.argOdradeniDioSpecijalizacije
            var uredi = false
            if(uneseniOdradeniDioSpecijalizacije!=null)
            {
                uredi = true
                var godina = uneseniOdradeniDioSpecijalizacije.trajeOd!!.split("-")[0].toInt()
                var mjesec = uneseniOdradeniDioSpecijalizacije.trajeOd!!.split("-")[1].toInt()
                var dan = uneseniOdradeniDioSpecijalizacije.trajeOd!!.split("-")[2].toInt()
                datePickerOd.updateDate(godina, mjesec - 1, dan)
                if(uneseniOdradeniDioSpecijalizacije.trajeDo==null){
                    _binding!!.datePickerDo.updateDate(godina, mjesec, dan)
                }
                _binding!!.inputDioSpecijalizacije.editText?.setText(uneseniOdradeniDioSpecijalizacije.dioSpecijalizacije!!.toString())
                _binding!!.inputDioSpecijalizacije.setVisibility(View.GONE)
                if(uneseniOdradeniDioSpecijalizacije.glavniMentorPotpis=="1") { _binding!!.glavniMentorPotpis.isChecked=true }
                else { _binding!!.glavniMentorPotpis.isChecked=false }
            }
            else{
                _binding!!.datePickerDo.setVisibility(View.GONE)
            }

            _binding!!.gumbPotvrdi.setOnClickListener {
                val godina = datePickerOd.year - 1900
                val mjesec = datePickerOd.month
                val dan = datePickerOd.dayOfMonth
                val datum = Date(godina, mjesec, dan)
                val formatter = SimpleDateFormat("yyyy-MM-dd")
                val trajeOd = formatter.format(datum)
                val brojDioSpecijalizacija = _binding!!.spinner.text?.toString()!!.toInt()
                val idSpecijlizacije = args.argSpecijalizacijaId.toInt()
                var glavniMentorPotpis : String? = null
                if(_binding!!.glavniMentorPotpis.isChecked==true) { glavniMentorPotpis="1" }
                else { glavniMentorPotpis="0" }
                var trajeDo : String? = null
                if(uredi!=true){
                    trajeDo = null
                }else{
                    val godinaDo = _binding!!.datePickerDo.year - 1900
                    val mjesecDo = _binding!!.datePickerDo.month
                    val danDo = _binding!!.datePickerDo.dayOfMonth
                    val datumDo = Date(godinaDo, mjesecDo, danDo)
                    trajeDo = formatter.format(datumDo)
                    if(trajeDo==trajeOd) { trajeDo=null }
                }

                val odradeniDioSpecijalizacije = OdradeniDioSpecijalizacije(idSpecijlizacije, brojDioSpecijalizacija, 1, null, glavniMentorPotpis, trajeOd, trajeDo)

                if(uredi==false){
                    webServis.dodajOdradeniDioSpecijalizacije(odradeniDioSpecijalizacije) {
                    }
                } else{
                    if(uneseniOdradeniDioSpecijalizacije!!.mentorPotpis!=null) { odradeniDioSpecijalizacije.mentorPotpis = uneseniOdradeniDioSpecijalizacije!!.mentorPotpis }
                    webServis.urediOdradeniDioSpecijalizacije(odradeniDioSpecijalizacije) {
                    }
                }

                val action = UnosOdradenogDijelaSpecijalizacijeDirections.actionUnosOdradenogDijelaSpecijalizacijeToSpecijalizantPracenjeSpecijlizacije()
                this.findNavController().navigate(action)
            }

        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        webServis.getSpecijalizacijaById(args.argSpecijalizacijaId.toInt())
        webServis.specijalizacija.observe(viewLifecycleOwner){
            webServis.getDijeloviSpecijalizacije(it.programSpecijalizacijeId!!.toInt())
        }

    }
}
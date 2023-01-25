package hr.foi.air.ednevnik.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.ws.WebServis
import hr.foi.air.ednevnik.databinding.MentorDnevnikPrikazUnosaBinding
import java.text.SimpleDateFormat

class PrikazUnosaOdradenaKompetencijaDnevnikFragment : Fragment(){
    private val args : PrikazUnosaOdradenaKompetencijaDnevnikFragmentArgs by navArgs<PrikazUnosaOdradenaKompetencijaDnevnikFragmentArgs>()
    private var _binding: MentorDnevnikPrikazUnosaBinding? = null
    private val binding: MentorDnevnikPrikazUnosaBinding
    get() = _binding!!


    lateinit var webServis: WebServis

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        webServis = WebServis()
        webServis.getKompetencija(args.argOdradenaKompetencija.kompetencija!!.toInt())

        _binding = MentorDnevnikPrikazUnosaBinding.inflate(inflater, container, false)

        _binding!!.naslovUnosaDnevnika.text = ""
        _binding!!.opisDnevnika.text = ""


        return binding.root
    }

    private fun prikaziPodatke() : String
    {
        var odradenaKompetencija = args.argOdradenaKompetencija
        var opis = "";
        var mentor = args.argMentor
        var kompetencija = webServis.kompetencija.value

        if(kompetencija?.nazivKompetencija!=null)
        {
            opis += "\nNaziv kompetencije: ${kompetencija!!.nazivKompetencija}"
        }
        opis += "\nStupanj kompetencije: ${odradenaKompetencija.stupanj}"
        if(odradenaKompetencija.potpisMentora==null || odradenaKompetencija.potpisMentora.toString()=="0")
        { opis += "\nPotpis mentora: Ne" }
        else if(odradenaKompetencija.potpisMentora.toString()=="1")
        { opis += "\nPotpis mentora: Da" }

        if(!mentor || odradenaKompetencija.potpisMentora=="1"){
            binding.gumbPotpisi.hide()
        }
        if(mentor){
            binding.gumbUredi.hide()
        }

        binding.gumbPotpisi.setOnClickListener{
            odradenaKompetencija.potpisMentora = "1"
            webServis.urediOdradenuKompetenciju(odradenaKompetencija){
                this.findNavController().popBackStack()
            }
        }

        return opis;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("TAG OnViewCreated", webServis.kompetencija.value.toString())
        observeLiveData()
    }

    private fun observeLiveData() {
        webServis.kompetencija.observe(viewLifecycleOwner) {
            _binding!!.naslovUnosaDnevnika.text = args.argOdradenaKompetencija.datum
            _binding!!.opisDnevnika.text = prikaziPodatke()
        }
    }
}
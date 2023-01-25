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

class PrikazUnosaOdradeniZahvatDnevnikFragment : Fragment(){
    private val args : PrikazUnosaOdradeniZahvatDnevnikFragmentArgs by navArgs<PrikazUnosaOdradeniZahvatDnevnikFragmentArgs>()
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
        webServis.getZahvat(args.argOdradeniZahvat.zahvat!!.toInt())

        _binding = MentorDnevnikPrikazUnosaBinding.inflate(inflater, container, false)

        _binding!!.naslovUnosaDnevnika.text = ""
        _binding!!.opisDnevnika.text = ""


        return binding.root
    }

    private fun prikaziPodatke() : String
    {
        var odradeniZahvat = args.argOdradeniZahvat
        var opis = "";
        var mentor = args.argMentor
        var zahvat = webServis.zahvat.value

        if(zahvat?.nazivZahvat!=null)
        {
            opis += "\nNaziv zahvata: ${zahvat!!.nazivZahvat}"
        }
        opis += "\nStupanj zahvata: ${odradeniZahvat.stupanj}"
        if(odradeniZahvat.potpisMentora==null || odradeniZahvat.potpisMentora.toString()=="0")
        { opis += "\nPotpis mentora: Ne" }
        else if(odradeniZahvat.potpisMentora.toString()=="1")
        { opis += "\nPotpis mentora: Da" }

        if(!mentor || odradeniZahvat.potpisMentora=="1"){
            binding.gumbPotpisi.hide()
        }
        if(mentor){
            binding.gumbUredi.hide()
        }

        binding.gumbPotpisi.setOnClickListener{
            odradeniZahvat.potpisMentora = "1"
            webServis.urediOdradeniZahvat(odradeniZahvat){
                this.findNavController().popBackStack()
            }
        }

        return opis;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("TAG OnViewCreated", webServis.zahvat.value.toString())
        observeLiveData()
    }

    private fun observeLiveData() {
        webServis.zahvat.observe(viewLifecycleOwner) {
            _binding!!.naslovUnosaDnevnika.text = args.argOdradeniZahvat.datum
            _binding!!.opisDnevnika.text = prikaziPodatke()
        }
    }
}
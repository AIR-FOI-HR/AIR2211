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

class PrikazUnosaOdradeniDioSpecijalizacijeDnevnikFragment : Fragment(){
    private val args : PrikazUnosaOdradeniDioSpecijalizacijeDnevnikFragmentArgs by navArgs<PrikazUnosaOdradeniDioSpecijalizacijeDnevnikFragmentArgs>()
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
        webServis.getDioSpecijalizacije(args.argOdradeniDioSpecijalizacije.dioSpecijalizacije!!.toInt())
        webServis.getMentor(args.argOdradeniDioSpecijalizacije.mentor)

        _binding = MentorDnevnikPrikazUnosaBinding.inflate(inflater, container, false)

        _binding!!.naslovUnosaDnevnika.text = ""
        _binding!!.opisDnevnika.text = ""


        return binding.root
    }

    private fun prikaziPodatke() : String
    {
        var odradeniDioSpecijalizacije = args.argOdradeniDioSpecijalizacije
        var opis = "";
        var mentor = args.argMentor

        var dioSpecijalizacije = webServis.dioSpecijalizacije.value
        var ustrojstvenaJedinica = webServis.ustrojstvenaJedinica.value
        var mentorSpec = webServis.mentor.value

        if(ustrojstvenaJedinica!=null)
        {
            opis += "\nUstanova: ${ustrojstvenaJedinica!!.nazivUstanova}"
            opis += "\nOdjel: ${ustrojstvenaJedinica!!.nazivJedinica}"
        }

        if(mentorSpec!=null)
        {
            opis += "\nMentor dijela specijalizacije: ${mentorSpec!!.ime} ${mentorSpec!!.prezime}"
        }
        if(odradeniDioSpecijalizacije.mentorPotpis==null || odradeniDioSpecijalizacije.mentorPotpis.toString()=="0")
        { opis += "\nPotpis mentora spcijalizacije: Ne" }
        else if(odradeniDioSpecijalizacije.mentorPotpis.toString()=="1")
        { opis += "\nPotpis mentora specijalizacije: Da" }

        if(odradeniDioSpecijalizacije.glavniMentorPotpis==null || odradeniDioSpecijalizacije.glavniMentorPotpis.toString()=="0")
        { opis += "\nPotpis glavnog mentora: Ne" }
        else if(odradeniDioSpecijalizacije.glavniMentorPotpis.toString()=="1")
        { opis += "\nPotpis glavnog mentora: Da" }

        if(!mentor || odradeniDioSpecijalizacije.mentorPotpis=="1"){
            binding.gumbPotpisi.hide()
        }
        if(mentor){
            binding.gumbUredi.hide()
        }

        binding.gumbPotpisi.setOnClickListener{
            odradeniDioSpecijalizacije.mentorPotpis = "1"
            webServis.urediOdradeniDioSpecijalizacije(odradeniDioSpecijalizacije){
                this.findNavController().popBackStack()
            }
        }

        return opis;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("TAG OnViewCreated", webServis.dioSpecijalizacije.value.toString())
        observeLiveData()
    }

    private fun observeLiveData() {
        webServis.dioSpecijalizacije.observe(viewLifecycleOwner) {
            webServis.getUstrojstvenaJedinica(webServis.dioSpecijalizacije.value!!.ustrojstvenaJedinica)
        }
        webServis.ustrojstvenaJedinica.observe(viewLifecycleOwner) {
            if(args.argOdradeniDioSpecijalizacije.trajeDo==null) {
                _binding!!.naslovUnosaDnevnika.text = args.argOdradeniDioSpecijalizacije.trajeOd
            } else{
                _binding!!.naslovUnosaDnevnika.text = "${(args.argOdradeniDioSpecijalizacije.trajeOd)} do ${args.argOdradeniDioSpecijalizacije.trajeDo}"
            }

            _binding!!.opisDnevnika.text = prikaziPodatke()
        }
    }
}
package hr.foi.air.ednevnik.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.core.entities.Pitanje
import com.example.ws.WebServis
import hr.foi.air.ednevnik.databinding.MentorDnevnikPrikazUnosaBinding
import java.text.SimpleDateFormat

class PrikazUnosaProvjeraZnanjaDnevnikFragment : Fragment(){
    private val args : PrikazUnosaProvjeraZnanjaDnevnikFragmentArgs by navArgs<PrikazUnosaProvjeraZnanjaDnevnikFragmentArgs>()
    private var _binding: MentorDnevnikPrikazUnosaBinding? = null
    private val binding: MentorDnevnikPrikazUnosaBinding
        get() = _binding!!

    lateinit var webServis: WebServis

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        var provjeraZnanja = args.argProvjeraZnanja
        var opis = "";

        webServis = WebServis()
        webServis.getAllPitanja(args.argProvjeraZnanja.idProvjera!!.toInt())


        _binding = MentorDnevnikPrikazUnosaBinding.inflate(inflater, container, false)

        _binding!!.naslovUnosaDnevnika.text = SimpleDateFormat("yyyy-MM-dd").format(provjeraZnanja.datumProvjera)

        if(provjeraZnanja.ocjenaProvjera!=null)
        {
            opis += "Ocjena: ${provjeraZnanja.ocjenaProvjera}"
        }
        else{
            opis += "Ocjena: Nije ocijenjeno"
        }
        if(provjeraZnanja.potpisMentora==null || provjeraZnanja.potpisMentora.toString()=="0")
        { opis += "\nPotpis mentora: Ne" }
        else if(provjeraZnanja.potpisMentora.toString()=="1")
        { opis += "\nPotpis mentora: Da" }

        opis+="${webServis.pitanja.value}"

        _binding!!.opisDnevnika.text = opis;

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}
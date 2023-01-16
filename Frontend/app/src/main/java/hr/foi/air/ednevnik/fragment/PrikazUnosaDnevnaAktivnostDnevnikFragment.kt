package hr.foi.air.ednevnik.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import hr.foi.air.ednevnik.databinding.MentorDnevnikPrikazUnosaBinding
import java.text.SimpleDateFormat

class PrikazUnosaDnevnaAktivnostDnevnikFragment : Fragment(){
    private var _binding: MentorDnevnikPrikazUnosaBinding? = null
    private val binding: MentorDnevnikPrikazUnosaBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        var opis = "";

        _binding = MentorDnevnikPrikazUnosaBinding.inflate(inflater, container, false)

        _binding!!.naslovUnosaDnevnika.text = "${arguments?.getString("argNazivAktivnosti")}"

        opis += "Naziv aktivnosti: ${arguments?.getString("argNazivAktivnosti")}"
        opis += "\nDatum aktivnosti: ${SimpleDateFormat("yyyy-MM-dd").format(arguments?.get("argDatumAktivnosti"))}"

        if(arguments?.getString("argOpisAktivnosti")!=null)
        {
            opis += "\nOpis aktivnosti: ${arguments?.getString("argOpisAktivnosti")}"
        }
        if(arguments?.getString("argBrZahvataNadzor")!=null)
        {
            opis += "\nBroj zahvata pod nadzorom: ${arguments?.getString("argBrZahvataNadzor")}"
        }
        if(arguments?.getString("argBrZahvataSamostalno")!=null)
        {
            opis += "\nBroj samostalnih zahvata: ${arguments?.getString("argBrZahvataSamostalno")}"
        }
        if(arguments?.get("argPotpisMentora")==null || arguments?.get("argPotpisMentora").toString()=="0")
        { opis += "\nPotpis mentora: Ne" }
        else if(arguments?.get("argPotpisMentora").toString()=="1")
        { opis += "\nPotpis mentora: Da" }

        _binding!!.opisDnevnika.text = opis;

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}
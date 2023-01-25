package hr.foi.air.ednevnik.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.ws.WebServis
import hr.foi.air.ednevnik.databinding.MentorDnevnikPrikazUnosaBinding
import java.text.SimpleDateFormat

class PrikazUnosaDnevnaAktivnostDnevnikFragment : Fragment(){
    private val args : PrikazUnosaDnevnaAktivnostDnevnikFragmentArgs by navArgs<PrikazUnosaDnevnaAktivnostDnevnikFragmentArgs>()
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
        var dnevnaAktivnost = args.argDnevnaAktivnost
        var mentor = args.argMentor
        var opis = "";

        _binding = MentorDnevnikPrikazUnosaBinding.inflate(inflater, container, false)

        _binding!!.naslovUnosaDnevnika.text = dnevnaAktivnost.nazivAktivnost

        opis += "\nDatum aktivnosti: ${dnevnaAktivnost.datumAktivnost}"

        if(dnevnaAktivnost.opisAktivnost!=null)
        {
            opis += "\nOpis aktivnosti: ${dnevnaAktivnost.opisAktivnost}"
        }
        if(dnevnaAktivnost.brZahvataNadzor!=null)
        {
            opis += "\nBroj zahvata pod nadzorom: ${dnevnaAktivnost.brZahvataNadzor}"
        }
        if(dnevnaAktivnost.brZahvataSamostalno!=null)
        {
            opis += "\nBroj samostalnih zahvata: ${dnevnaAktivnost.brZahvataSamostalno}"
        }
        if(dnevnaAktivnost.potpisMentora==null || dnevnaAktivnost.potpisMentora.toString()=="0")
        { opis += "\nPotpis mentora: Ne" }
        else if(dnevnaAktivnost.potpisMentora.toString()=="1")
        { opis += "\nPotpis mentora: Da" }

        _binding!!.opisDnevnika.text = opis;

        if(!mentor!! || dnevnaAktivnost.potpisMentora=="1"){
            binding.gumbPotpisi.hide()
        }
        if(mentor!!){
            binding.gumbUredi.hide()
        }

        binding.gumbPotpisi.setOnClickListener{
            dnevnaAktivnost.potpisMentora = "1"
            webServis.urediDnevnuAktivnost(dnevnaAktivnost){
                this.findNavController().popBackStack()
            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}
package hr.foi.air.ednevnik.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.ws.WebServis
import hr.foi.air.ednevnik.databinding.MentorDnevnikPrikazUnosaBinding
import java.text.SimpleDateFormat

class PrikazUnosaSlucajBolesnikaDnevnikFragment : Fragment() {
    private val args : PrikazUnosaSlucajBolesnikaDnevnikFragmentArgs by navArgs<PrikazUnosaSlucajBolesnikaDnevnikFragmentArgs>()
    private var _binding: MentorDnevnikPrikazUnosaBinding? = null
    private val binding: MentorDnevnikPrikazUnosaBinding
        get() = _binding!!


    lateinit var webServis: WebServis

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        var opis = "";
        var slucajBolesnika = args.argSlucajBolesnika
        var mentor = args.argMentor
        _binding = MentorDnevnikPrikazUnosaBinding.inflate(inflater, container, false)
        _binding!!.naslovUnosaDnevnika.text = slucajBolesnika.datumSlucaj

        if(slucajBolesnika.opisSlucaj!=null) {opis += "\nOpis slučaja: ${slucajBolesnika.opisSlucaj}"}
        if(slucajBolesnika.dijagnozaSlucaj!=null) {opis += "\nDijagnoza slučaja: ${slucajBolesnika.dijagnozaSlucaj}"}
        if(slucajBolesnika.potpisMentora==null || slucajBolesnika.potpisMentora.toString()=="0")
        { opis += "\nPotpis mentora: Ne" }
        else if(slucajBolesnika.potpisMentora.toString()=="1")
        { opis += "\nPotpis mentora: Da" }

        _binding!!.opisDnevnika.text = opis

        if(!mentor || slucajBolesnika.potpisMentora=="1"){
            binding.gumbPotpisi.hide()
        }
        if(mentor){
            binding.gumbUredi.hide()
        }

        binding.gumbPotpisi.setOnClickListener{
            slucajBolesnika.potpisMentora = "1"
            webServis.urediSlucajBolesnika(slucajBolesnika){
                this.findNavController().popBackStack()
            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}
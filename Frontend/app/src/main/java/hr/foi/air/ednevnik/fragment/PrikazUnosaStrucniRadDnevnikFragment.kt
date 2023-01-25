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

class PrikazUnosaStrucniRadDnevnikFragment : Fragment() {
    private val args : PrikazUnosaStrucniRadDnevnikFragmentArgs by navArgs<PrikazUnosaStrucniRadDnevnikFragmentArgs>()
    private var _binding: MentorDnevnikPrikazUnosaBinding? = null
    private val binding: MentorDnevnikPrikazUnosaBinding
        get() = _binding!!

    lateinit var webServis: WebServis

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        var strucniRad = args.argStrucniRad
        var opis = "";
        var mentor = args.argMentor

        _binding = MentorDnevnikPrikazUnosaBinding.inflate(inflater, container, false)

        _binding!!.naslovUnosaDnevnika.text = strucniRad.naslovRad

        opis += "Naslov rada: ${strucniRad.naslovRad}"

        if(strucniRad.objavljenU!=null) { opis += "\nObjavljen u: ${strucniRad.objavljenU}" }
        else{ opis += "\nStrucni rad nije objavljen." }

        _binding!!.opisDnevnika.text = opis;

        binding.gumbPotpisi.hide()
        if(mentor){
            binding.gumbUredi.hide()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}
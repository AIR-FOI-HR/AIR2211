package hr.foi.air.ednevnik.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import hr.foi.air.ednevnik.databinding.MentorDnevnikPrikazUnosaBinding

class PrikazUnosaIspitiDnevnikFragment : Fragment() {
    private val args : PrikazUnosaIspitiDnevnikFragmentArgs by navArgs<PrikazUnosaIspitiDnevnikFragmentArgs>()
    private var _binding: MentorDnevnikPrikazUnosaBinding? = null
    private val binding: MentorDnevnikPrikazUnosaBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        var opis = "";
        var ispit = args.argIspit
        var mentor = args.argMentor

        _binding = MentorDnevnikPrikazUnosaBinding.inflate(inflater, container, false)
        _binding!!.naslovUnosaDnevnika.text = ispit.datum

        opis += "\nNaziv ustanove: ${ispit.nazivUstanove}"
        opis += "\nVrijeme održavanja: ${ispit.vrijemeOdrzavanja}"
        if(ispit.prosao.toString()=="0")
        { opis += "\nProšao: Ne" }
        else if(ispit.prosao.toString()=="1")
        { opis += "\nProšao: Da" }

        _binding!!.opisDnevnika.text = opis

        binding.gumbPotpisi.hide()
        if(!mentor){
            binding.gumbUredi.hide()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}
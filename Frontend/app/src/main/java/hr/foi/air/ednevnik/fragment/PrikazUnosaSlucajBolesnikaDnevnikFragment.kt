package hr.foi.air.ednevnik.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import hr.foi.air.ednevnik.databinding.MentorDnevnikPrikazUnosaBinding

class PrikazUnosaSlucajBolesnikaDnevnikFragment : Fragment() {
    private var _binding: MentorDnevnikPrikazUnosaBinding? = null
    private val binding: MentorDnevnikPrikazUnosaBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MentorDnevnikPrikazUnosaBinding.inflate(inflater, container, false)

        _binding!!.naslovUnosaDnevnika.text = "${arguments?.getString("argDatumSlucaja")}"

        _binding!!.opisDnevnika.text = "Opis slučaja: ${arguments?.getString("argOpisSlucaja")} \nDijagnoza slučaja: ${arguments?.getString("argDijagnozaSlucaja")}"

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}
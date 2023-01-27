package hr.foi.air.ednevnik.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import hr.foi.air.ednevnik.MainActivity
import hr.foi.air.ednevnik.R
import hr.foi.air.ednevnik.databinding.SpecijalizantProfilBinding

class ProfilSpecijalizantaFragment : Fragment(){
    private var _binding: SpecijalizantProfilBinding? = null
    private val binding: SpecijalizantProfilBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = SpecijalizantProfilBinding.inflate(inflater, container, false)

        _binding!!.imePrezime.text = "${MainActivity.specijalizant!!.ime} ${MainActivity.specijalizant!!.prezime}"
        _binding!!.email.text = MainActivity.specijalizant!!.email
        _binding!!.lozinka.text = MainActivity.specijalizant!!.lozinka

        _binding!!.gumbUredi.setOnClickListener{
            val action = ProfilSpecijalizantaFragmentDirections.actionProfilSpecijalizantaFragmentToUrediProfilFragment()
            this.findNavController().navigate(action)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}
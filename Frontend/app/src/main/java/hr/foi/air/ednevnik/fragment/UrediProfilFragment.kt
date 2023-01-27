package hr.foi.air.ednevnik.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.set
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.core.entities.Specijalizant
import com.example.ws.WebServis
import hr.foi.air.ednevnik.MainActivity
import hr.foi.air.ednevnik.R
import hr.foi.air.ednevnik.databinding.SpecijalizantProfilBinding
import hr.foi.air.ednevnik.databinding.SpecijalizantUrediProfilBinding

class UrediProfilFragment : Fragment(){
    private var _binding: SpecijalizantUrediProfilBinding? = null
    private val binding: SpecijalizantUrediProfilBinding
        get() = _binding!!

    lateinit var webServis: WebServis

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = SpecijalizantUrediProfilBinding.inflate(inflater, container, false)

        _binding!!.imePrezime.text = "${MainActivity.specijalizant!!.ime} ${MainActivity.specijalizant!!.prezime}"
        _binding!!.updateEmail.editText!!.setText(MainActivity.specijalizant!!.email)
        _binding!!.updateLozinka.editText!!.setText(MainActivity.specijalizant!!.lozinka)

        webServis = WebServis()

        _binding!!.gumbPotvrdiUredivanjeSpecijalizanta.setOnClickListener{
            val specijalizant = Specijalizant(MainActivity.specijalizant!!.id_specijalizant, MainActivity.specijalizant!!.ime, MainActivity.specijalizant!!.prezime,
                _binding!!.updateEmail.editText!!.text.toString(), _binding!!.updateLozinka.editText!!.text.toString())

            webServis.urediSpecijalizanta(specijalizant) {
                this.findNavController().navigate(R.id.action_global_specijalizantPracenjeSpecijalizacije)
            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}
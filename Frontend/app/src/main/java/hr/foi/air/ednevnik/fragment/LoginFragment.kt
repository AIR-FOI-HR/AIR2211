package hr.foi.air.ednevnik.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.core.entities.Prijava
import com.example.ws.WebServis
import hr.foi.air.ednevnik.MainActivity
import hr.foi.air.ednevnik.databinding.LoginBinding


class LoginFragment : Fragment() {
    private var _binding: LoginBinding? = null
    private val binding: LoginBinding
        get() = _binding!!

    private lateinit var webServis: WebServis

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = LoginBinding.inflate(inflater, container, false)
        webServis = WebServis()

        _binding!!.loginMentor.setOnClickListener() {
            val prijava = Prijava(_binding!!.inputEmail.editText!!.text.toString(), _binding!!.inputLozinka.editText!!.text.toString())
            webServis.mentorPrijava(prijava) {
                MainActivity.mentor = it
                val action = LoginFragmentDirections.actionLoginFragmentToSpecijalizantiFragment()
                this.findNavController().navigate(action)
            }
        }

        _binding!!.loginSpecijalizant.setOnClickListener {
            val prijava = Prijava(_binding!!.inputEmail.editText!!.text.toString(), _binding!!.inputLozinka.editText!!.text.toString())
            webServis.specijalizantPrijava(prijava) {
                MainActivity.specijalizant = it
                val action = LoginFragmentDirections.actionLoginFragmentToSpecijalizantPracenjeSpecijlizacije()
                this.findNavController().navigate(action)
            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
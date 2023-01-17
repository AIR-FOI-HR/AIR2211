package hr.foi.air.ednevnik.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import hr.foi.air.ednevnik.databinding.LoginBinding


class LoginFragment : Fragment() {
    private var _binding: LoginBinding? = null
    private val binding: LoginBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = LoginBinding.inflate(inflater, container, false)

        _binding!!.loginMentor.setOnClickListener() {
            val action = LoginFragmentDirections.actionLoginFragmentToSpecijalizantiFragment()
            this.findNavController().navigate(action)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
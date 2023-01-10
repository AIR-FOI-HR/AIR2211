package hr.foi.air.ednevnik.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ws.SpecijalizantiWebServis
import hr.foi.air.ednevnik.databinding.MentorPracenjeSpecijalizacijeBinding
import hr.foi.air.ednevnik.specijalizanti_recyclerview.SpecijalizantAdapter

class PracenjeSpecijalizantaFragment : Fragment() {
    private var _binding: MentorPracenjeSpecijalizacijeBinding? = null
    private val binding: MentorPracenjeSpecijalizacijeBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MentorPracenjeSpecijalizacijeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}
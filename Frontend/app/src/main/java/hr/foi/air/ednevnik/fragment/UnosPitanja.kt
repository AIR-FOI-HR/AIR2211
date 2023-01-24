package hr.foi.air.ednevnik.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.core.entities.Pitanje
import com.example.ws.WebServis
import hr.foi.air.ednevnik.databinding.SpecijalizantDodajPitanjeBinding

class UnosPitanja : Fragment() {
    private val args : UnosPitanjaArgs by navArgs<UnosPitanjaArgs>()
    private var _binding: SpecijalizantDodajPitanjeBinding? = null
    private val binding: SpecijalizantDodajPitanjeBinding
        get() = _binding!!

    lateinit var webServis: WebServis

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = SpecijalizantDodajPitanjeBinding.inflate(inflater, container, false)

        webServis = WebServis()


        _binding!!.gumbPotvrdiPitanje.setOnClickListener {
            val sadrzaj = _binding!!.inputSadrzajPitanja.editText?.text.toString()
            Log.d("TAG", args.argProvjeraId)
            val idProvjera = args.argProvjeraId.toInt()

            val pitanje = Pitanje(id, idProvjera, sadrzaj)

            webServis.dodajPitanje(pitanje) {
                this.findNavController().popBackStack()
            }

        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        webServis = WebServis()
    }
}
package hr.foi.air.ednevnik.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.core.entities.Specijalizacija
import com.example.ws.WebServis
import hr.foi.air.ednevnik.databinding.LoginBinding
import hr.foi.air.ednevnik.databinding.MentorUnosParametaraSpecijalizacijeBinding
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class UnosSpecijalizacijeFragment : Fragment() {
    private val args : UnosSpecijalizacijeFragmentArgs by navArgs<UnosSpecijalizacijeFragmentArgs>()
    private var _binding: MentorUnosParametaraSpecijalizacijeBinding? = null
    private val binding: MentorUnosParametaraSpecijalizacijeBinding
        get() = _binding!!

    lateinit var webServis: WebServis
    val listaSpecijalizacija = arrayOf("1", "2", "3")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = MentorUnosParametaraSpecijalizacijeBinding.inflate(inflater, container, false)

        _binding!!.spcijalizantIme.text = "${args.argSpecijlizant.ime} ${args.argSpecijlizant.prezime}"
        _binding!!.gumbPotvrdiSpecijlizaciju.setOnClickListener {
            val formatter = SimpleDateFormat("yyyy-MM-dd")
            val current = formatter.format(Date())
            var specijalizacija = Specijalizacija(null, args.argSpecijlizant.id_specijalizant, 1, 1, "test", current, null, null, "")
            webServis.dodajSpecijlizaciju(specijalizacija) {
                if(it == null){
                    Log.d("Tag", "Error pri dodavanju nove specke")
                }
            }
            val action = UnosSpecijalizacijeFragmentDirections.actionUnosSpecijalizacijeFragmentToSpecijalizantiFragment()
            this.findNavController().navigate(action)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        webServis = WebServis()
    }
}
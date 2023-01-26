package hr.foi.air.ednevnik.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.ws.WebServis
import hr.foi.air.ednevnik.databinding.MentorZatvoriSpecijalizacijuBinding
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.Calendar
import java.util.Date

class MentorZatvaranjeSpecijalizacijeFragment : Fragment() {
    private val args : MentorZatvaranjeSpecijalizacijeFragmentArgs by navArgs<MentorZatvaranjeSpecijalizacijeFragmentArgs>()
    private var _binding: MentorZatvoriSpecijalizacijuBinding? = null
    private val binding: MentorZatvoriSpecijalizacijuBinding
        get() = _binding!!

    lateinit var webServis: WebServis

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = MentorZatvoriSpecijalizacijuBinding.inflate(inflater, container, false)
        var specijalizacija = args.argSpecijalizacija
        webServis = WebServis()

        _binding!!.gumbPotvrdi.setOnClickListener {

            val formatter = SimpleDateFormat("yyyy-MM-dd")
            val date = Date()
            val current = formatter.format(date)

            specijalizacija.zavrsnoMisljenje = _binding!!.inputZavrsnoMisljenje.editText?.text.toString()
            specijalizacija.potpisMentora ="1"
            specijalizacija.datumZavrsetka = current

            webServis.urediSpecijalizaciju(specijalizacija) {
                var action = MentorZatvaranjeSpecijalizacijeFragmentDirections.actionGlobalSpecijalizantiFragment()
                this.findNavController().navigate(action)
            }

        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        webServis = WebServis()
    }
}
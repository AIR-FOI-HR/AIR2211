package hr.foi.air.ednevnik.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.navigation.fragment.findNavController
import com.example.core.entities.Specijalizacija
import com.example.ws.WebServis
import hr.foi.air.ednevnik.databinding.MentorPracenjeSpecijalizacijeBinding
import java.text.SimpleDateFormat

class PracenjeSpecijalizantaFragment : Fragment() {
    private var _binding: MentorPracenjeSpecijalizacijeBinding? = null
    private val binding: MentorPracenjeSpecijalizacijeBinding
        get() = _binding!!

    private lateinit var webServis: WebServis
    private lateinit var specijalizacija : LiveData<Specijalizacija>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MentorPracenjeSpecijalizacijeBinding.inflate(inflater, container, false)

        _binding!!.spcijalizantIme.text = "${arguments?.getString("argSpecijalizantIme")} ${arguments?.getString("argSpecijalizantPrezime")}"

        var gumbSlucajBolesnika = _binding!!.slucajBolesnika

        gumbSlucajBolesnika.setOnClickListener() {
            Log.d("PracnjeTAG", webServis.specijalizacija.value.toString())
            val action = PracenjeSpecijalizantaFragmentDirections.actionPracenjeSpecijalizantaFragmentToSlucajeviBolesnikaFragment(webServis.specijalizacija.value!!.id_specijalizacija.toString())
            this.findNavController().navigate(action)
        }

        var gumbStrucniRad = _binding!!.strucniRad

        gumbStrucniRad.setOnClickListener() {
            Log.d("PracnjeTAG", webServis.specijalizacija.value.toString())
            val action = PracenjeSpecijalizantaFragmentDirections.actionPracenjeSpecijalizantaFragmentToStrucniRadoviFragment(webServis.specijalizacija.value!!.id_specijalizacija.toString())
            this.findNavController().navigate(action)
        }

        var gumbDnevnaAktivnost = _binding!!.dnevnaAktivnost

        gumbDnevnaAktivnost.setOnClickListener() {
            Log.d("PracnjeTAG", webServis.specijalizacija.value.toString())
            val action = PracenjeSpecijalizantaFragmentDirections.actionPracenjeSpecijalizantaFragmentToDnevneAktivnostiFragment(webServis.specijalizacija.value!!.id_specijalizacija.toString())
            this.findNavController().navigate(action)
        }

        var gumbProvjeraZnanja = _binding!!.provjeraZnanja

        gumbProvjeraZnanja.setOnClickListener() {
            Log.d("PracnjeTAG", webServis.specijalizacija.value.toString())
            val action = PracenjeSpecijalizantaFragmentDirections.actionPracenjeSpecijalizantaFragmentToProvjereZnanjaFragment(webServis.specijalizacija.value!!.id_specijalizacija.toString())
            this.findNavController().navigate(action)
        }

        var gumbOdradeneKompetencije = _binding!!.kompetencija

        gumbOdradeneKompetencije.setOnClickListener() {
            Log.d("PracnjeTAG", webServis.specijalizacija.value.toString())
            val action = PracenjeSpecijalizantaFragmentDirections.actionPracenjeSpecijalizantaFragmentToOdradeneKompetencijeFragment(webServis.specijalizacija.value!!.id_specijalizacija.toString())
            this.findNavController().navigate(action)
        }

        var gumbOdradeniZahvati = _binding!!.zahvat

        gumbOdradeniZahvati.setOnClickListener() {
            Log.d("PracnjeTAG", webServis.specijalizacija.value.toString())
            val action = PracenjeSpecijalizantaFragmentDirections.actionPracenjeSpecijalizantaFragmentToOdradeniZahvatiFragment(webServis.specijalizacija.value!!.id_specijalizacija.toString())
            this.findNavController().navigate(action)
        }

        var gumbOdradeniDijeloviSpecijalizacije = _binding!!.dioSpecijalizacije

        gumbOdradeniDijeloviSpecijalizacije.setOnClickListener() {
            Log.d("PracnjeTAG", webServis.specijalizacija.value.toString())
            val action = PracenjeSpecijalizantaFragmentDirections.actionPracenjeSpecijalizantaFragmentToOdradeniDijeloviSpecijalizacijeFragment(webServis.specijalizacija.value!!.id_specijalizacija.toString())
            this.findNavController().navigate(action)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        webServis = WebServis()

        webServis.getSpecijalizacija(arguments?.getString("argSpecijalizantId")!!.toInt())

        observeLiveData()
    }

    private fun observeLiveData() {

        webServis.getUstrojstvenaJedinicaBySpecijalizant(arguments?.getString("argSpecijalizantId")!!.toInt())

        webServis.ustrojstvenaJedinica.observe(viewLifecycleOwner) {
            if(it==null) {
                _binding!!.spcijalizantTrenutniOdjel.text = "Trenutno nije na odjelu!"
            } else{
                _binding!!.spcijalizantTrenutniOdjel.text = "${webServis.ustrojstvenaJedinica.value!!.nazivUstanova}\n${webServis.ustrojstvenaJedinica.value!!.nazivJedinica}"
            }
        }
    }
}
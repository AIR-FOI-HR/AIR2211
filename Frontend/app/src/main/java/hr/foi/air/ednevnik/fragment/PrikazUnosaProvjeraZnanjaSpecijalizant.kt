package hr.foi.air.ednevnik.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ws.WebServis
import hr.foi.air.ednevnik.databinding.SpecijalizantProvjeraZnanjaPrikazBinding
import hr.foi.air.ednevnik.recyclerview_adapters.PitanjaAdapter

class PrikazUnosaProvjeraZnanjaSpecijalizant : Fragment(){
    private val args : PrikazUnosaProvjeraZnanjaDnevnikFragmentArgs by navArgs<PrikazUnosaProvjeraZnanjaDnevnikFragmentArgs>()
    private var _binding: SpecijalizantProvjeraZnanjaPrikazBinding? = null
    private val binding: SpecijalizantProvjeraZnanjaPrikazBinding
        get() = _binding!!

    lateinit var webServis: WebServis

    private lateinit var pitanjaAdapter: PitanjaAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val provjeraZnanja = args.argProvjeraZnanja
        var opis = "";

        _binding = SpecijalizantProvjeraZnanjaPrikazBinding.inflate(inflater, container, false)

        _binding!!.naslovUnosaKnjizice.text = provjeraZnanja.datumProvjera

        if(provjeraZnanja.ocjenaProvjera!=null)
        {
            opis += "Ocjena: ${provjeraZnanja.ocjenaProvjera}"
        }
        else{
            opis += "Ocjena: Nije ocijenjeno"
        }
        if(provjeraZnanja.potpisMentora==null || provjeraZnanja.potpisMentora.toString()=="0")
        { opis += "\nPotpis mentora: Ne" }
        else if(provjeraZnanja.potpisMentora.toString()=="1")
        { opis += "\nPotpis mentora: Da" }

        _binding!!.opisKnjzice.text = opis;

        _binding!!.fabNovo.setOnClickListener {
            Log.d("Tag", arguments?.getString("argSpecijalizacijaId").toString())
            val action =
                PrikazUnosaProvjeraZnanjaSpecijalizantDirections.actionPrikazUnosaProvjeraZnanjaSpecijalizantToUnosPitanja(
                    args.argProvjeraZnanja.idProvjera.toString()
                )
            this.findNavController().navigate(action)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        webServis = WebServis()
        webServis.getAllPitanja(args.argProvjeraZnanja.idProvjera!!.toInt())

        initRecyclerView()
        observeLiveData()
    }

    override fun onResume() {
        super.onResume()
        Log.d("Tag", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
    }

    private fun observeLiveData() {
        webServis.pitanja.observe(viewLifecycleOwner) {
            pitanjaAdapter.setData(it)
        }
    }

    private fun initRecyclerView() {
        pitanjaAdapter = PitanjaAdapter()

        binding.knjizicaRecycler.adapter = pitanjaAdapter
        binding.knjizicaRecycler.layoutManager = LinearLayoutManager(context)
    }
}
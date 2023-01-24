package hr.foi.air.ednevnik.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ws.WebServis
import hr.foi.air.ednevnik.databinding.SpecijalizantListaDnevnikBinding
import hr.foi.air.ednevnik.recyclerview_adapters.SlucajeviBolesnikaAdapter

class SpecijalizantSlucajeviBolesnika : Fragment(){
    private var _binding: SpecijalizantListaDnevnikBinding? = null
    private val binding: SpecijalizantListaDnevnikBinding
        get() = _binding!!

    private lateinit var slucajBolesnikaListAdapter: SlucajeviBolesnikaAdapter

    private lateinit var webServis: WebServis

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = SpecijalizantListaDnevnikBinding.inflate(inflater, container, false)

        _binding!!.fabNovo.setOnClickListener{
            Log.d("Tag", arguments?.getString("argSpecijalizacijaId").toString())
            val action = SpecijalizantSlucajeviBolesnikaDirections.actionSpecijalizantSlucajeviBolesnikaToUnosSlucajaBolesnika(arguments?.getString("argSpecijalizacijaId").toString())
            this.findNavController().navigate(action)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        webServis = WebServis()

        webServis.getAllSlucajeviBolesnika(arguments?.getString("argSpecijalizacijaId")!!.toInt())

        initRecyclerView()
        observeLiveData()
    }

    private fun observeLiveData() {
        webServis.slucajeviBolesnika.observe(viewLifecycleOwner) {
            slucajBolesnikaListAdapter.setData(it)
        }
    }

    private fun initRecyclerView() {
        slucajBolesnikaListAdapter = SlucajeviBolesnikaAdapter()

        slucajBolesnikaListAdapter.mentor = false
        slucajBolesnikaListAdapter.onItemClick = {slucajBolesnika ->
            Log.d("SpecTAG", "${slucajBolesnika.idSlucaj}")
            val action = SpecijalizantSlucajeviBolesnikaDirections.actionSpecijalizantSlucajeviBolesnikaToPrikazUnosaSlucajBolesnikaDnevnikFragment(slucajBolesnika)
            this.findNavController().navigate(action)
        }

        binding.dnevnikRecyclerSpecijalizant.adapter = slucajBolesnikaListAdapter
        binding.dnevnikRecyclerSpecijalizant.layoutManager = LinearLayoutManager(context)
    }
}
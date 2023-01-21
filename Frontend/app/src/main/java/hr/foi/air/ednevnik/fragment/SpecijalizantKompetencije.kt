package hr.foi.air.ednevnik.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ws.WebServis
import hr.foi.air.ednevnik.databinding.SpecijalizantListaDnevnikBinding
import hr.foi.air.ednevnik.recyclerview_adapters.OdradeneKompetencijeAdapter
import hr.foi.air.ednevnik.recyclerview_adapters.OdradeniZahvatiAdapter

class SpecijalizantKompetencije : Fragment(){
    private var _binding: SpecijalizantListaDnevnikBinding? = null
    private val binding: SpecijalizantListaDnevnikBinding
        get() = _binding!!

    private lateinit var kompetencijeAdapter: OdradeneKompetencijeAdapter

    private lateinit var webServis: WebServis

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = SpecijalizantListaDnevnikBinding.inflate(inflater, container, false)

        _binding!!.fabNovo.setOnClickListener{
            val action = SpecijalizantKompetencijeDirections.actionSpecijalizantKompetencijeToUnosOdradeneKompetencije(arguments?.getString("argSpecijalizacijaId").toString())
            this.findNavController().navigate(action)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        webServis = WebServis()

        webServis.getAllOdradeneKompetencije(arguments?.getString("argSpecijalizacijaId")!!.toInt())

        initRecyclerView()
        observeLiveData()
    }

    private fun observeLiveData() {
        webServis.odradeneKompetencije.observe(viewLifecycleOwner) {
            kompetencijeAdapter.setData(it)
        }
    }

    private fun initRecyclerView() {
        kompetencijeAdapter = OdradeneKompetencijeAdapter()

        kompetencijeAdapter.onItemClick = {kompetencija ->
            val action = SpecijalizantKompetencijeDirections.actionSpecijalizantKompetencijeToPrikazUnosaOdradenaKompetencijaDnevnikFragment(kompetencija)
            this.findNavController().navigate(action)
        }

        binding.dnevnikRecyclerSpecijalizant.adapter = kompetencijeAdapter
        binding.dnevnikRecyclerSpecijalizant.layoutManager = LinearLayoutManager(context)
    }
}
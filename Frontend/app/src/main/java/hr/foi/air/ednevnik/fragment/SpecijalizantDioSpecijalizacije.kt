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
import hr.foi.air.ednevnik.recyclerview_adapters.OdradeniDijeloviSpecijalizacijeAdapter

class SpecijalizantDioSpecijalizacije : Fragment(){
    private var _binding: SpecijalizantListaDnevnikBinding? = null
    private val binding: SpecijalizantListaDnevnikBinding
        get() = _binding!!

    private lateinit var dioSpecijalizacijeAdapter: OdradeniDijeloviSpecijalizacijeAdapter

    private lateinit var webServis: WebServis

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = SpecijalizantListaDnevnikBinding.inflate(inflater, container, false)

        _binding!!.fabNovo.setOnClickListener{
            val action = SpecijalizantDioSpecijalizacijeDirections.actionSpecijalizantDioSpecijalizacijeToUnosOdradenogDijelaSpecijalizacije(arguments?.getString("argSpecijalizacijaId").toString())
            this.findNavController().navigate(action)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        webServis = WebServis()

        webServis.getAllOdradeniDijeloviSpecijalizacije(arguments?.getString("argSpecijalizacijaId")!!.toInt())

        initRecyclerView()
        observeLiveData()
    }

    private fun observeLiveData() {
        webServis.odradeniDijeloviSpecijalizacije.observe(viewLifecycleOwner) {
            dioSpecijalizacijeAdapter.setData(it)
        }
    }

    private fun initRecyclerView() {
        dioSpecijalizacijeAdapter = OdradeniDijeloviSpecijalizacijeAdapter()
        dioSpecijalizacijeAdapter.mentor=false
        dioSpecijalizacijeAdapter.onItemClick = {dioSpecijalizacije ->
            val action = SpecijalizantDioSpecijalizacijeDirections.actionSpecijalizantDioSpecijalizacijeToPrikazUnosaOdradeniDioSpecijalizacijeDnevnikFragment(dioSpecijalizacije)
            this.findNavController().navigate(action)
        }

        binding.dnevnikRecyclerSpecijalizant.adapter = dioSpecijalizacijeAdapter
        binding.dnevnikRecyclerSpecijalizant.layoutManager = LinearLayoutManager(context)
    }
}
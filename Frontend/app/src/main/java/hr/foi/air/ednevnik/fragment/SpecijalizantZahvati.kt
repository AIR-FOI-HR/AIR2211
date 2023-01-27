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
import hr.foi.air.ednevnik.recyclerview_adapters.DnevneAktivnostiAdapter
import hr.foi.air.ednevnik.recyclerview_adapters.OdradeniZahvatiAdapter

class SpecijalizantZahvati : Fragment(){
    private var _binding: SpecijalizantListaDnevnikBinding? = null
    private val binding: SpecijalizantListaDnevnikBinding
        get() = _binding!!

    private lateinit var zahvatiAdapter: OdradeniZahvatiAdapter

    private lateinit var webServis: WebServis

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = SpecijalizantListaDnevnikBinding.inflate(inflater, container, false)

        _binding!!.fabNovo.setOnClickListener{
            val action = SpecijalizantZahvatiDirections.actionSpecijalizantZahvatiToUnosOdrađenogZahvata(arguments?.getString("argSpecijalizacijaId").toString())
            this.findNavController().navigate(action)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        webServis = WebServis()

        webServis.getAllOdradeniZahvati(arguments?.getString("argSpecijalizacijaId")!!.toInt())

        initRecyclerView()
        observeLiveData()
    }

    private fun observeLiveData() {
        webServis.odradeniZahvati.observe(viewLifecycleOwner) {
            zahvatiAdapter.setData(it)
        }
    }

    private fun initRecyclerView() {
        zahvatiAdapter = OdradeniZahvatiAdapter()
        zahvatiAdapter.mentor = false
        zahvatiAdapter.onItemClick = {zahvat ->
            val action = SpecijalizantZahvatiDirections.actionSpecijalizantZahvatiToPrikazUnosaOdradeniZahvatDnevnikFragment(zahvat, false)
            this.findNavController().navigate(action)
        }

        binding.dnevnikRecyclerSpecijalizant.adapter = zahvatiAdapter
        binding.dnevnikRecyclerSpecijalizant.layoutManager = LinearLayoutManager(context)
    }
}
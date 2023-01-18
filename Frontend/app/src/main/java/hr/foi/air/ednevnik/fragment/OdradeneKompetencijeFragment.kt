package hr.foi.air.ednevnik.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ws.WebServis
import hr.foi.air.ednevnik.databinding.MentorListaDnevnikBinding
import hr.foi.air.ednevnik.recyclerview_adapters.OdradeneKompetencijeAdapter

class OdradeneKompetencijeFragment : Fragment(){
    private var _binding: MentorListaDnevnikBinding? = null
    private val binding: MentorListaDnevnikBinding
        get() = _binding!!

    private lateinit var odradenaKompetencijaListAdapter: OdradeneKompetencijeAdapter

    private lateinit var webServis: WebServis

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = MentorListaDnevnikBinding.inflate(inflater, container, false)
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
            odradenaKompetencijaListAdapter.setData(it)
        }
    }

    private fun initRecyclerView() {
        odradenaKompetencijaListAdapter = OdradeneKompetencijeAdapter()

        odradenaKompetencijaListAdapter.onItemClick = {odradenaKompetencija ->
            //Log.d("SpecTAG", "${odradenaKompetencija.}")
            val action = OdradeneKompetencijeFragmentDirections.actionOdradeneKompetencijeFragmentToPrikazUnosaOdradenaKompetencijaDnevnikFragment(odradenaKompetencija)
            this.findNavController().navigate(action)
        }

        binding.dnevnikRecycler.adapter = odradenaKompetencijaListAdapter
        binding.dnevnikRecycler.layoutManager = LinearLayoutManager(context)
    }
}
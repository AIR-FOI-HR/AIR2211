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
import hr.foi.air.ednevnik.databinding.MentorListaDnevnikBinding
import hr.foi.air.ednevnik.recyclerview_adapters.ProvjereZnanjaAdapter

class ProvjereZnanjaFragment : Fragment(){
    private var _binding: MentorListaDnevnikBinding? = null
    private val binding: MentorListaDnevnikBinding
        get() = _binding!!

    private lateinit var provjeraZnanjaListAdapter: ProvjereZnanjaAdapter

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

        webServis.getAllProvjereZnanja(arguments?.getString("argSpecijalizacijaId")!!.toInt())

        initRecyclerView()
        observeLiveData()
    }

    private fun observeLiveData() {
        webServis.provjereZnanja.observe(viewLifecycleOwner) {
            provjeraZnanjaListAdapter.setData(it)
        }
    }

    private fun initRecyclerView() {
        provjeraZnanjaListAdapter = ProvjereZnanjaAdapter()

        provjeraZnanjaListAdapter.onItemClick = {provjeraZnanja ->
            Log.d("SpecTAG", "${provjeraZnanja.idProvjera}")
            val action = ProvjereZnanjaFragmentDirections.actionProvjereZnanjaFragmentToPrikazUnosaProvjeraZnanjaDnevnikFragment(provjeraZnanja)
            this.findNavController().navigate(action)
        }

        binding.dnevnikRecycler.adapter = provjeraZnanjaListAdapter
        binding.dnevnikRecycler.layoutManager = LinearLayoutManager(context)
    }
}
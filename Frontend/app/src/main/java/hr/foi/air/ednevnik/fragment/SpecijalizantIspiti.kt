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
import hr.foi.air.ednevnik.recyclerview_adapters.IspitiAdapter

class SpecijalizantIspiti : Fragment(){
    private var _binding: MentorListaDnevnikBinding? = null
    private val binding: MentorListaDnevnikBinding
        get() = _binding!!

    private lateinit var ispitListAdapter: IspitiAdapter

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

        webServis.getAllIspiti(arguments?.getString("argSpecijalizacijaId")!!.toInt())

        initRecyclerView()
        observeLiveData()
    }

    private fun observeLiveData() {
        webServis.ispiti.observe(viewLifecycleOwner) {
            ispitListAdapter.setData(it)
        }
    }

    private fun initRecyclerView() {
        ispitListAdapter = IspitiAdapter()

        ispitListAdapter.onItemClick = {ispit ->
            Log.d("SpecTAG", "${ispit.idIspit}")
            val action = SpecijalizantIspitiDirections.actionSpecijalizantIspitiToPrikazUnosaIspitiDnevnikFragment(ispit)
            this.findNavController().navigate(action)
        }

        binding.dnevnikRecycler.adapter = ispitListAdapter
        binding.dnevnikRecycler.layoutManager = LinearLayoutManager(context)
    }
}
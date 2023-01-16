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
import hr.foi.air.ednevnik.recyclerview_adapters.StrucniRadoviAdapter

class StrucniRadoviFragment : Fragment(){
    private var _binding: MentorListaDnevnikBinding? = null
    private val binding: MentorListaDnevnikBinding
        get() = _binding!!

    private lateinit var strucniRadListAdapter: StrucniRadoviAdapter

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

        webServis.getAllStrucniRadovi(arguments?.getString("argSpecijalizacijaId")!!.toInt())

        initRecyclerView()
        observeLiveData()
    }

    private fun observeLiveData() {
        webServis.strucniRadovi.observe(viewLifecycleOwner) {
            strucniRadListAdapter.setData(it)
        }
    }

    private fun initRecyclerView() {
        strucniRadListAdapter = StrucniRadoviAdapter()

        strucniRadListAdapter.onItemClick = {strucniRad ->
            Log.d("SpecTAG", "${strucniRad.idRad}")
            val action = StrucniRadoviFragmentDirections.actionStrucniRadoviFragmentToPrikazUnosaDnevnikFragment2(strucniRad.naslovRad, strucniRad.objavljenU)
            this.findNavController().navigate(action)
        }

        binding.dnevnikRecycler.adapter = strucniRadListAdapter
        binding.dnevnikRecycler.layoutManager = LinearLayoutManager(context)
    }
}
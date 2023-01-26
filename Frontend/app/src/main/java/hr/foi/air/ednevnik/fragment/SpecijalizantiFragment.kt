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
import hr.foi.air.ednevnik.MainActivity
import hr.foi.air.ednevnik.R
import hr.foi.air.ednevnik.databinding.MentorListaSpecijalizanataBinding
import hr.foi.air.ednevnik.recyclerview_adapters.SpecijalizantAdapter

class SpecijalizantiFragment : Fragment(){

    private var _binding: MentorListaSpecijalizanataBinding? = null
    private val binding: MentorListaSpecijalizanataBinding
        get() = _binding!!

    private lateinit var specijalizantListAdapter: SpecijalizantAdapter

    private lateinit var specijalizantWebServis: WebServis

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = MentorListaSpecijalizanataBinding.inflate(inflater, container, false)

        var gumb = _binding!!.fabNovaSpecijalizacija

        gumb.setOnClickListener() {
            val action = SpecijalizantiFragmentDirections.actionSpecijalizantiFragmentToSviSpecijalizantiFragment()
            this.findNavController().navigate(action)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        specijalizantWebServis = WebServis()

        specijalizantWebServis.getAllSpecijalizantiByMentorId(MainActivity.mentor?.idMentor!!)

        MainActivity.homeAction = R.id.action_global_specijalizantiFragment

        initRecyclerView()
        observeLiveData()
    }

    private fun observeLiveData() {
        specijalizantWebServis.specijalizanti.observe(viewLifecycleOwner) {
            specijalizantListAdapter.setData(it)
        }
    }

    private fun initRecyclerView() {
        specijalizantListAdapter = SpecijalizantAdapter()

        specijalizantListAdapter.onItemClick = {specijalizant ->
            Log.d("SpecTAG", "${specijalizant.id_specijalizant}")
            val action = SpecijalizantiFragmentDirections.actionSpecijalizantiFragmentToPracenjeSpecijalizantaFragment(specijalizant.ime, specijalizant.prezime, specijalizant.id_specijalizant.toString())
            this.findNavController().navigate(action)
        }

        binding.specijalizantiRecycler.adapter = specijalizantListAdapter
        binding.specijalizantiRecycler.layoutManager = LinearLayoutManager(context)
    }
}
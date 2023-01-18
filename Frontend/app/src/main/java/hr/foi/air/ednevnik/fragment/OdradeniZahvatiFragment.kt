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
import hr.foi.air.ednevnik.recyclerview_adapters.OdradeniZahvatiAdapter

class OdradeniZahvatiFragment : Fragment(){
    private var _binding: MentorListaDnevnikBinding? = null
    private val binding: MentorListaDnevnikBinding
        get() = _binding!!

    private lateinit var odradeniZahvatListAdapter: OdradeniZahvatiAdapter

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

        webServis.getAllOdradeniZahvati(arguments?.getString("argSpecijalizacijaId")!!.toInt())

        initRecyclerView()
        observeLiveData()
    }

    private fun observeLiveData() {
        webServis.odradeniZahvati.observe(viewLifecycleOwner) {
            odradeniZahvatListAdapter.setData(it)
        }
    }

    private fun initRecyclerView() {
        odradeniZahvatListAdapter = OdradeniZahvatiAdapter()

        odradeniZahvatListAdapter.onItemClick = {odradeniZahvat ->
            val action = OdradeniZahvatiFragmentDirections.actionOdradeniZahvatiFragmentToPrikazUnosaOdradeniZahvatDnevnikFragment(odradeniZahvat)
            this.findNavController().navigate(action)
        }

        binding.dnevnikRecycler.adapter = odradeniZahvatListAdapter
        binding.dnevnikRecycler.layoutManager = LinearLayoutManager(context)
    }
}
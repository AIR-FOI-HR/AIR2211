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
import hr.foi.air.ednevnik.recyclerview_adapters.DnevneAktivnostiAdapter

class DnevneAktivnostiFragment : Fragment(){
    private var _binding: MentorListaDnevnikBinding? = null
    private val binding: MentorListaDnevnikBinding
        get() = _binding!!

    private lateinit var dnevnaAktivnostListAdapter: DnevneAktivnostiAdapter

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

        webServis.getAllDnevneAktivnosti(arguments?.getString("argSpecijalizacijaId")!!.toInt())

        initRecyclerView()
        observeLiveData()
    }

    private fun observeLiveData() {
        webServis.dnevneAktivnosti.observe(viewLifecycleOwner) {
            dnevnaAktivnostListAdapter.setData(it)
        }
    }

    private fun initRecyclerView() {
        dnevnaAktivnostListAdapter = DnevneAktivnostiAdapter()

        dnevnaAktivnostListAdapter.onItemClick = {dnevnaAktivnost ->
            Log.d("SpecTAG", "${dnevnaAktivnost.idAktivnost}")
            val action = DnevneAktivnostiFragmentDirections.actionDnevneAktivnostiFragmentToPrikazUnosaDnevnaAktivnostDnevnikFragment(dnevnaAktivnost.datumAktivnost, dnevnaAktivnost.nazivAktivnost, dnevnaAktivnost.opisAktivnost, dnevnaAktivnost.brZahvataNadzor.toString(), dnevnaAktivnost.brZahvataSamostalno.toString(), dnevnaAktivnost.potpisMentora)
            this.findNavController().navigate(action)
        }

        binding.dnevnikRecycler.adapter = dnevnaAktivnostListAdapter
        binding.dnevnikRecycler.layoutManager = LinearLayoutManager(context)
    }
}
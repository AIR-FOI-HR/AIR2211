package hr.foi.air.ednevnik.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.core.entities.Ispit
import com.example.ws.WebServis
import hr.foi.air.ednevnik.databinding.MentorListaDnevnikBinding
import hr.foi.air.ednevnik.recyclerview_adapters.ObavijestiAdapter
import hr.foi.air.ednevnik.recyclerview_adapters.ProvjereZnanjaAdapter

class ObavijestiFragment1 : Fragment(), PrikazObavijesti{
    private var _binding: MentorListaDnevnikBinding? = null
    private val binding: MentorListaDnevnikBinding
        get() = _binding!!

    private lateinit var obavijestiListAdapter: ObavijestiAdapter
    var ispitiLista : List<Ispit>? = null

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

        initRecyclerView()
    }

    private fun initRecyclerView() {
        obavijestiListAdapter = ObavijestiAdapter()

        obavijestiListAdapter.setData(ispitiLista!!)

        binding.dnevnikRecycler.adapter = obavijestiListAdapter
        binding.dnevnikRecycler.layoutManager = LinearLayoutManager(context)
    }

    override fun setData(ispiti: List<Ispit>?) {
        ispitiLista = ispiti
    }
}
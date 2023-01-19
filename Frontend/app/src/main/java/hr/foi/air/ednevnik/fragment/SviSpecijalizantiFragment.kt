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
import hr.foi.air.ednevnik.databinding.MentorListaSvihSpecijalizanataBinding
import hr.foi.air.ednevnik.recyclerview_adapters.SpecijalizantAdapter

class SviSpecijalizantiFragment : Fragment(){
    private var _binding: MentorListaSvihSpecijalizanataBinding? = null
    private val binding: MentorListaSvihSpecijalizanataBinding
        get() = _binding!!

    private lateinit var specijalizantListAdapter: SpecijalizantAdapter

    private lateinit var specijalizantWebServis: WebServis

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MentorListaSvihSpecijalizanataBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        specijalizantWebServis = WebServis()

        specijalizantWebServis.getAllSpecijalizanti()

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
            val action = SviSpecijalizantiFragmentDirections.actionSviSpecijalizantiFragmentToUnosSpecijalizacijeFragment(specijalizant)
            this.findNavController().navigate(action)
        }

        binding.specijalizantiRecycler.adapter = specijalizantListAdapter
        binding.specijalizantiRecycler.layoutManager = LinearLayoutManager(context)
    }
}
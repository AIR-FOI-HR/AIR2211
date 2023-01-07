package hr.foi.air.ednevnik.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ws.SpecijalizantiWebServis
import hr.foi.air.ednevnik.databinding.MentorListaSpecijalizanataBinding
import hr.foi.air.ednevnik.specijalizanti_recyclerview.SpecijalizantAdapter

class SpecijalizantiFragment : Fragment(){

    private var _binding: MentorListaSpecijalizanataBinding? = null
    private val binding: MentorListaSpecijalizanataBinding
        get() = _binding!!

    private lateinit var specijalizantListAdapter: SpecijalizantAdapter

    private lateinit var specijalizantWebServis: SpecijalizantiWebServis

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MentorListaSpecijalizanataBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        specijalizantWebServis = SpecijalizantiWebServis()

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
        binding.specijalizantiRecycler.adapter = specijalizantListAdapter
        binding.specijalizantiRecycler.layoutManager = LinearLayoutManager(context)
    }
}
package hr.foi.air.ednevnik.recyclerview_adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.core.entities.Pitanje
import com.example.core.entities.ProvjeraZnanja
import com.example.ws.WebServis
import hr.foi.air.ednevnik.databinding.MentorDnevnikCardBinding
import hr.foi.air.ednevnik.databinding.SpecijalizantDnevnikCardBinding
import java.text.SimpleDateFormat

class PitanjaAdapter (
    private var pitanjaArrayList: ArrayList<Pitanje> = arrayListOf()
) : RecyclerView.Adapter<PitanjaAdapter.PitanjaViewHolder>(){

    var mentor : Boolean = true
    var pitanjeId : Int? = null

    lateinit var webServis: WebServis


    inner class PitanjaViewHolder(private val binding : SpecijalizantDnevnikCardBinding)
        : RecyclerView.ViewHolder(binding.root)
    {
        fun bind(pitanje: Pitanje) {
            pitanjeId = pitanje.idPitanje
            binding.dnevnikNaslov.text = pitanje.sadrzajPitanja
            binding.tipUnosaDnevnik.text = ""
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PitanjaViewHolder {
        val binding =
            SpecijalizantDnevnikCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        if(mentor) {
            binding.gumbObrisi.hide()
            binding.gumbUredi.hide()
        }
        webServis = WebServis()

        binding.gumbObrisi.setOnClickListener{
            webServis.obrisiPitanje(pitanjeId!!){
                parent.findNavController().popBackStack()
            }
        }

        return PitanjaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PitanjaViewHolder, position: Int) {
        val pitanje = pitanjaArrayList[position]
        holder.bind(pitanje)
    }

    override fun getItemCount(): Int {
        return pitanjaArrayList.size
    }

    fun setData(newData: List<Pitanje>) {
        pitanjaArrayList.clear()
        pitanjaArrayList.addAll(newData)
        notifyDataSetChanged()
    }
}
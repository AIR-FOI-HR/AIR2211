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

    lateinit var webServis: WebServis


    inner class PitanjaViewHolder(private val binding : SpecijalizantDnevnikCardBinding)
        : RecyclerView.ViewHolder(binding.root)
    {
        fun bind(pitanje: Pitanje) {
            binding.dnevnikNaslov.text = pitanje.sadrzajPitanja
            binding.tipUnosaDnevnik.text = ""
            binding.gumbObrisi.setOnClickListener{
                webServis.obrisiPitanje(pitanje.idPitanje!!){
                    pitanjaArrayList.remove(pitanje)
                    notifyDataSetChanged()
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PitanjaViewHolder {
        val binding =
            SpecijalizantDnevnikCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        if(mentor) {
            binding.gumbObrisi.hide()
        }
        webServis = WebServis()

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
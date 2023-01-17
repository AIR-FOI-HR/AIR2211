package hr.foi.air.ednevnik.recyclerview_adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.core.entities.Pitanje
import com.example.core.entities.ProvjeraZnanja
import hr.foi.air.ednevnik.databinding.MentorDnevnikCardBinding
import java.text.SimpleDateFormat

class PitanjaAdapter (
    private var pitanjaArrayList: ArrayList<Pitanje> = arrayListOf()
) : RecyclerView.Adapter<PitanjaAdapter.PitanjaViewHolder>(){

    inner class PitanjaViewHolder(private val binding : MentorDnevnikCardBinding)
        : RecyclerView.ViewHolder(binding.root)
    {
        fun bind(pitanje: Pitanje) {
            binding.dnevnikNaslov.text = pitanje.sadrzajPitanja
            binding.tipUnosaDnevnik.text = ""
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PitanjaViewHolder {
        val binding =
            MentorDnevnikCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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
package hr.foi.air.ednevnik.recyclerview_adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.core.entities.ProvjeraZnanja
import hr.foi.air.ednevnik.databinding.MentorDnevnikCardBinding
import java.text.SimpleDateFormat

class ProvjereZnanjaAdapter (
    private var provjereZnanjaArrayList: ArrayList<ProvjeraZnanja> = arrayListOf()
) : RecyclerView.Adapter<ProvjereZnanjaAdapter.ProvjereZnanjaViewHolder>(){

    var onItemClick: ((ProvjeraZnanja) -> Unit)? = null

    inner class ProvjereZnanjaViewHolder(private val binding : MentorDnevnikCardBinding)
        : RecyclerView.ViewHolder(binding.root)
    {
        fun bind(provjeraZnanja: ProvjeraZnanja) {
            binding.dnevnikNaslov.text = provjeraZnanja.datumProvjera
            binding.tipUnosaDnevnik.text = ""
        }

        init {
            itemView.setOnClickListener{
                onItemClick?.invoke(provjereZnanjaArrayList[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProvjereZnanjaViewHolder {
        val binding =
            MentorDnevnikCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProvjereZnanjaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProvjereZnanjaViewHolder, position: Int) {
        val provjeraZnanja = provjereZnanjaArrayList[position]
        holder.bind(provjeraZnanja)
    }

    override fun getItemCount(): Int {
        return provjereZnanjaArrayList.size
    }

    fun setData(newData: List<ProvjeraZnanja>) {
        provjereZnanjaArrayList.clear()
        provjereZnanjaArrayList.addAll(newData)
        notifyDataSetChanged()
    }
}
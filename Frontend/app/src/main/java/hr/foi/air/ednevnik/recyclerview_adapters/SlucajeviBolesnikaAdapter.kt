package hr.foi.air.ednevnik.recyclerview_adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.core.entities.SlucajBolesnika
import hr.foi.air.ednevnik.databinding.MentorDnevnikCardBinding

class SlucajeviBolesnikaAdapter (
    private var slucajeviBolesnikaArrayList: ArrayList<SlucajBolesnika> = arrayListOf()
) : RecyclerView.Adapter<SlucajeviBolesnikaAdapter.SlucajeviBolesnikaViewHolder>(){

    var onItemClick: ((SlucajBolesnika) -> Unit)? = null

    inner class SlucajeviBolesnikaViewHolder(private val binding : MentorDnevnikCardBinding)
        : RecyclerView.ViewHolder(binding.root)
    {
        fun bind(slucajBolesnika: SlucajBolesnika) {
            binding.dnevnikNaslov.text = "${slucajBolesnika.datumSlucaj}"
            binding.tipUnosaDnevnik.text = slucajBolesnika.opisSlucaj
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SlucajeviBolesnikaViewHolder {
        val binding =
            MentorDnevnikCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SlucajeviBolesnikaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SlucajeviBolesnikaViewHolder, position: Int) {
        val slucajBolesnika = slucajeviBolesnikaArrayList[position]
        holder.bind(slucajBolesnika)
    }

    override fun getItemCount(): Int {
        return slucajeviBolesnikaArrayList.size
    }

    fun setData(newData: List<SlucajBolesnika>) {
        slucajeviBolesnikaArrayList.clear()
        slucajeviBolesnikaArrayList.addAll(newData)
        notifyDataSetChanged()
    }
}
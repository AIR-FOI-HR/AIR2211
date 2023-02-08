package hr.foi.air.ednevnik.recyclerview_adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.core.entities.Ispit
import com.example.ws.WebServis
import hr.foi.air.ednevnik.databinding.MentorDnevnikCardBinding

class ObavijestiAdapter (
    private var ispitiArrayList: ArrayList<Ispit> = arrayListOf()
) : RecyclerView.Adapter<ObavijestiAdapter.ObavijestiViewHolder>(){

    lateinit var webServis: WebServis

    inner class ObavijestiViewHolder(private val binding : MentorDnevnikCardBinding)
        : RecyclerView.ViewHolder(binding.root)
    {
        fun bind(ispit: Ispit) {
            binding.dnevnikNaslov.text = ispit.datum
            binding.tipUnosaDnevnik.text = ispit.vrijemeOdrzavanja
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ObavijestiViewHolder {
        val binding =
            MentorDnevnikCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ObavijestiViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ObavijestiViewHolder, position: Int) {
        val provjeraZnanja = ispitiArrayList[position]
        holder.bind(provjeraZnanja)
    }

    override fun getItemCount(): Int {
        return ispitiArrayList.size
    }

    fun setData(newData: List<Ispit>) {
        ispitiArrayList.clear()
        ispitiArrayList.addAll(newData)
        notifyDataSetChanged()
    }
}
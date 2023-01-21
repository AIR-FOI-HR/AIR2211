package hr.foi.air.ednevnik.recyclerview_adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.core.entities.OdradenaKompetencija
import hr.foi.air.ednevnik.databinding.MentorDnevnikCardBinding
import java.text.SimpleDateFormat

class OdradeneKompetencijeAdapter (
    private var odradeneKompetencijeArrayList: ArrayList<OdradenaKompetencija> = arrayListOf()
) : RecyclerView.Adapter<OdradeneKompetencijeAdapter.OdradeneKompetencijeViewHolder>(){

    var onItemClick: ((OdradenaKompetencija) -> Unit)? = null

    inner class OdradeneKompetencijeViewHolder(private val binding : MentorDnevnikCardBinding)
        : RecyclerView.ViewHolder(binding.root)
    {
        fun bind(odradenaKompetencija: OdradenaKompetencija) {
            binding.dnevnikNaslov.text = odradenaKompetencija.datum
            binding.tipUnosaDnevnik.text = ""
        }

        init {
            itemView.setOnClickListener{
                onItemClick?.invoke(odradeneKompetencijeArrayList[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OdradeneKompetencijeViewHolder {
        val binding =
            MentorDnevnikCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OdradeneKompetencijeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OdradeneKompetencijeViewHolder, position: Int) {
        val odradenaKompetencija = odradeneKompetencijeArrayList[position]
        holder.bind(odradenaKompetencija)
    }

    override fun getItemCount(): Int {
        return odradeneKompetencijeArrayList.size
    }

    fun setData(newData: List<OdradenaKompetencija>) {
        odradeneKompetencijeArrayList.clear()
        odradeneKompetencijeArrayList.addAll(newData)
        notifyDataSetChanged()
    }
}
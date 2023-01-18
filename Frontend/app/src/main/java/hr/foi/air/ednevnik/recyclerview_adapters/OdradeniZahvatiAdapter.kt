package hr.foi.air.ednevnik.recyclerview_adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.core.entities.OdradeniZahvat
import hr.foi.air.ednevnik.databinding.MentorDnevnikCardBinding
import java.text.SimpleDateFormat

class OdradeniZahvatiAdapter (
    private var odradeniZahvatiArrayList: ArrayList<OdradeniZahvat> = arrayListOf()
) : RecyclerView.Adapter<OdradeniZahvatiAdapter.OdradeniZahvatiViewHolder>(){

    var onItemClick: ((OdradeniZahvat) -> Unit)? = null

    inner class OdradeniZahvatiViewHolder(private val binding : MentorDnevnikCardBinding)
        : RecyclerView.ViewHolder(binding.root)
    {
        fun bind(odradeniZahvat: OdradeniZahvat) {
            binding.dnevnikNaslov.text = SimpleDateFormat("yyyy-MM-dd").format(odradeniZahvat.datum)
            binding.tipUnosaDnevnik.text = ""
        }

        init {
            itemView.setOnClickListener{
                onItemClick?.invoke(odradeniZahvatiArrayList[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OdradeniZahvatiViewHolder {
        val binding =
            MentorDnevnikCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OdradeniZahvatiViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OdradeniZahvatiViewHolder, position: Int) {
        val odradeniZahvat = odradeniZahvatiArrayList[position]
        holder.bind(odradeniZahvat)
    }

    override fun getItemCount(): Int {
        return odradeniZahvatiArrayList.size
    }

    fun setData(newData: List<OdradeniZahvat>) {
        odradeniZahvatiArrayList.clear()
        odradeniZahvatiArrayList.addAll(newData)
        notifyDataSetChanged()
    }
}
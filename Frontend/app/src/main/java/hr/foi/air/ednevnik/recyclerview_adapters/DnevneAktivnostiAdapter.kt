package hr.foi.air.ednevnik.recyclerview_adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.core.entities.DnevnaAktivnost
import hr.foi.air.ednevnik.databinding.MentorDnevnikCardBinding
import java.text.SimpleDateFormat

class DnevneAktivnostiAdapter (
    private var dnevneAktivnostiArrayList: ArrayList<DnevnaAktivnost> = arrayListOf()
    ) : RecyclerView.Adapter<DnevneAktivnostiAdapter.DnevneAktivnostiViewHolder>(){

        var onItemClick: ((DnevnaAktivnost) -> Unit)? = null

        inner class DnevneAktivnostiViewHolder(private val binding : MentorDnevnikCardBinding)
            : RecyclerView.ViewHolder(binding.root)
        {
            fun bind(dnevnaAktivnost: DnevnaAktivnost) {
                binding.dnevnikNaslov.text = dnevnaAktivnost.nazivAktivnost
                binding.tipUnosaDnevnik.text = SimpleDateFormat("yyyy-MM-dd").format(dnevnaAktivnost.datumAktivnost)
            }

            init {
                itemView.setOnClickListener{
                    onItemClick?.invoke(dnevneAktivnostiArrayList[adapterPosition])
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DnevneAktivnostiViewHolder {
            val binding =
                MentorDnevnikCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return DnevneAktivnostiViewHolder(binding)
        }

        override fun onBindViewHolder(holder: DnevneAktivnostiViewHolder, position: Int) {
            val dnevnaAktivnost = dnevneAktivnostiArrayList[position]
            holder.bind(dnevnaAktivnost)
        }

        override fun getItemCount(): Int {
            return dnevneAktivnostiArrayList.size
        }

        fun setData(newData: List<DnevnaAktivnost>) {
            dnevneAktivnostiArrayList.clear()
            dnevneAktivnostiArrayList.addAll(newData)
            notifyDataSetChanged()
        }
}
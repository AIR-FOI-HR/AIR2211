package hr.foi.air.ednevnik.recyclerview_adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.core.entities.DnevnaAktivnost
import com.example.ws.WebServis
import hr.foi.air.ednevnik.databinding.SpecijalizantDnevnikCardBinding
import hr.foi.air.ednevnik.fragment.SpecijalizantDnevneAktivnostiDirections

class DnevneAktivnostiAdapter (
    private var dnevneAktivnostiArrayList: ArrayList<DnevnaAktivnost> = arrayListOf()
    ) : RecyclerView.Adapter<DnevneAktivnostiAdapter.DnevneAktivnostiViewHolder>(){

        var onItemClick: ((DnevnaAktivnost) -> Unit)? = null
        var mentor : Boolean = true

        lateinit var webServis: WebServis

        inner class DnevneAktivnostiViewHolder(private val binding : SpecijalizantDnevnikCardBinding)
            : RecyclerView.ViewHolder(binding.root)
        {
            fun bind(dnevnaAktivnost: DnevnaAktivnost) {
                binding.dnevnikNaslov.text = dnevnaAktivnost.nazivAktivnost
                binding.tipUnosaDnevnik.text = dnevnaAktivnost.datumAktivnost
                binding.gumbObrisi.setOnClickListener{
                    webServis.obrisiDnevnuAktivnost(dnevnaAktivnost.idAktivnost!!){
                        dnevneAktivnostiArrayList.remove(dnevnaAktivnost)
                        notifyDataSetChanged()
                    }
                }

            }

            init {
                itemView.setOnClickListener{
                    onItemClick?.invoke(dnevneAktivnostiArrayList[adapterPosition])
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DnevneAktivnostiViewHolder {
            val binding = SpecijalizantDnevnikCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)

            if(mentor) {
                binding.gumbObrisi.hide()
            }
            webServis = WebServis()

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
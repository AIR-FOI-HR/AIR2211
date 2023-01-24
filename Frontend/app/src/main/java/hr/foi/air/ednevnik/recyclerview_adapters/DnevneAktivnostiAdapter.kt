package hr.foi.air.ednevnik.recyclerview_adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.core.entities.DnevnaAktivnost
import com.example.ws.WebServis
import hr.foi.air.ednevnik.databinding.MentorDnevnikCardBinding
import hr.foi.air.ednevnik.databinding.SpecijalizantDnevnikCardBinding
import java.text.SimpleDateFormat

class DnevneAktivnostiAdapter (
    private var dnevneAktivnostiArrayList: ArrayList<DnevnaAktivnost> = arrayListOf()
    ) : RecyclerView.Adapter<DnevneAktivnostiAdapter.DnevneAktivnostiViewHolder>(){

        var onItemClick: ((DnevnaAktivnost) -> Unit)? = null
        var mentor : Boolean = true
        var aktivnostId : Int? = null

        lateinit var webServis: WebServis

        inner class DnevneAktivnostiViewHolder(private val binding : SpecijalizantDnevnikCardBinding)
            : RecyclerView.ViewHolder(binding.root)
        {
            fun bind(dnevnaAktivnost: DnevnaAktivnost) {
                aktivnostId = dnevnaAktivnost.idAktivnost
                binding.dnevnikNaslov.text = dnevnaAktivnost.nazivAktivnost
                binding.tipUnosaDnevnik.text = dnevnaAktivnost.datumAktivnost
            }

            init {
                itemView.setOnClickListener{
                    onItemClick?.invoke(dnevneAktivnostiArrayList[adapterPosition])
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DnevneAktivnostiViewHolder {
            val binding =
                SpecijalizantDnevnikCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)

            if(mentor) {binding.gumbObrisi.hide()}
            webServis = WebServis()

            binding.gumbObrisi.setOnClickListener{
                webServis.obrisiDnevnuAktivnost(aktivnostId!!){
                    parent.findNavController().popBackStack()
                }
            }

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
package hr.foi.air.ednevnik.recyclerview_adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.core.entities.ProvjeraZnanja
import com.example.ws.WebServis
import hr.foi.air.ednevnik.databinding.MentorDnevnikCardBinding
import hr.foi.air.ednevnik.databinding.SpecijalizantDnevnikCardBinding
import java.text.SimpleDateFormat

class ProvjereZnanjaAdapter (
    private var provjereZnanjaArrayList: ArrayList<ProvjeraZnanja> = arrayListOf()
) : RecyclerView.Adapter<ProvjereZnanjaAdapter.ProvjereZnanjaViewHolder>(){

    var onItemClick: ((ProvjeraZnanja) -> Unit)? = null
    var mentor : Boolean = true

    lateinit var webServis: WebServis

    inner class ProvjereZnanjaViewHolder(private val binding : SpecijalizantDnevnikCardBinding)
        : RecyclerView.ViewHolder(binding.root)
    {
        fun bind(provjeraZnanja: ProvjeraZnanja) {
            binding.dnevnikNaslov.text = provjeraZnanja.datumProvjera
            binding.tipUnosaDnevnik.text = ""
            binding.gumbObrisi.setOnClickListener{
                webServis.obrisiProvjeruZnanja(provjeraZnanja.idProvjera!!){
                    provjereZnanjaArrayList.remove(provjeraZnanja)
                    notifyDataSetChanged()
                }
            }
        }

        init {
            itemView.setOnClickListener{
                onItemClick?.invoke(provjereZnanjaArrayList[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProvjereZnanjaViewHolder {
        val binding =
            SpecijalizantDnevnikCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        if(mentor) {
            binding.gumbObrisi.hide()
        }
        webServis = WebServis()

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
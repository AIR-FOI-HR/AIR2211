package hr.foi.air.ednevnik.recyclerview_adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.core.entities.OdradenaKompetencija
import com.example.ws.WebServis
import hr.foi.air.ednevnik.databinding.MentorDnevnikCardBinding
import hr.foi.air.ednevnik.databinding.SpecijalizantDnevnikCardBinding
import hr.foi.air.ednevnik.fragment.SpecijalizantDnevneAktivnostiDirections
import hr.foi.air.ednevnik.fragment.SpecijalizantKompetencijeDirections
import java.text.SimpleDateFormat

class OdradeneKompetencijeAdapter (
    private var odradeneKompetencijeArrayList: ArrayList<OdradenaKompetencija> = arrayListOf()
) : RecyclerView.Adapter<OdradeneKompetencijeAdapter.OdradeneKompetencijeViewHolder>(){

    var onItemClick: ((OdradenaKompetencija) -> Unit)? = null
    var mentor : Boolean = true

    lateinit var webServis: WebServis

    inner class OdradeneKompetencijeViewHolder(private val binding : SpecijalizantDnevnikCardBinding)
        : RecyclerView.ViewHolder(binding.root)
    {
        fun bind(odradenaKompetencija: OdradenaKompetencija) {
            binding.dnevnikNaslov.text = odradenaKompetencija.datum
            binding.tipUnosaDnevnik.text = ""
            binding.gumbObrisi.setOnClickListener{
                webServis.obrisiOdradenuKompetenciju(odradenaKompetencija.specijalizacija!!, odradenaKompetencija.kompetencija!!, odradenaKompetencija.stupanj!!){
                    odradeneKompetencijeArrayList.remove(odradenaKompetencija)
                    notifyDataSetChanged()
                }
            }
        }

        init {
            itemView.setOnClickListener{
                onItemClick?.invoke(odradeneKompetencijeArrayList[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OdradeneKompetencijeViewHolder {
        val binding =
            SpecijalizantDnevnikCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        if(mentor) {
            binding.gumbObrisi.hide()
        }
        webServis = WebServis()

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
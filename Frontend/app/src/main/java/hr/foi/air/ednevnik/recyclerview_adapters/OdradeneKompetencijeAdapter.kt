package hr.foi.air.ednevnik.recyclerview_adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.core.entities.OdradenaKompetencija
import com.example.ws.WebServis
import hr.foi.air.ednevnik.databinding.MentorDnevnikCardBinding
import hr.foi.air.ednevnik.databinding.SpecijalizantDnevnikCardBinding
import java.text.SimpleDateFormat

class OdradeneKompetencijeAdapter (
    private var odradeneKompetencijeArrayList: ArrayList<OdradenaKompetencija> = arrayListOf()
) : RecyclerView.Adapter<OdradeneKompetencijeAdapter.OdradeneKompetencijeViewHolder>(){

    var onItemClick: ((OdradenaKompetencija) -> Unit)? = null
    var mentor : Boolean = true
    var specijalizacija : Int? = null
    var kompetencija : Int? = null
    var stupanj : Int? = null

    lateinit var webServis: WebServis

    inner class OdradeneKompetencijeViewHolder(private val binding : SpecijalizantDnevnikCardBinding)
        : RecyclerView.ViewHolder(binding.root)
    {
        fun bind(odradenaKompetencija: OdradenaKompetencija) {
            specijalizacija = odradenaKompetencija.specijalizacija
            kompetencija = odradenaKompetencija.kompetencija
            stupanj = odradenaKompetencija.stupanj
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
            SpecijalizantDnevnikCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        if(mentor) {
            binding.gumbObrisi.hide()
            binding.gumbUredi.hide()
        }
        webServis = WebServis()

        binding.gumbObrisi.setOnClickListener{
            webServis.obrisiOdradenuKompetenciju(specijalizacija!!, kompetencija!!, stupanj!!){
                parent.findNavController().popBackStack()
            }
        }

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
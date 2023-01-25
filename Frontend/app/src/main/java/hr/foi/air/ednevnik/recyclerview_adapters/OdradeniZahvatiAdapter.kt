package hr.foi.air.ednevnik.recyclerview_adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.core.entities.OdradeniZahvat
import com.example.ws.WebServis
import hr.foi.air.ednevnik.databinding.MentorDnevnikCardBinding
import hr.foi.air.ednevnik.databinding.SpecijalizantDnevnikCardBinding
import java.text.SimpleDateFormat

class OdradeniZahvatiAdapter (
    private var odradeniZahvatiArrayList: ArrayList<OdradeniZahvat> = arrayListOf()
) : RecyclerView.Adapter<OdradeniZahvatiAdapter.OdradeniZahvatiViewHolder>(){

    var onItemClick: ((OdradeniZahvat) -> Unit)? = null
    var mentor : Boolean = true
    var specijalizacija : Int? = null
    var zahvat : Int? = null
    var stupanj : Int? = null

    lateinit var webServis: WebServis

    inner class OdradeniZahvatiViewHolder(private val binding : SpecijalizantDnevnikCardBinding)
        : RecyclerView.ViewHolder(binding.root)
    {
        fun bind(odradeniZahvat: OdradeniZahvat) {
            specijalizacija = odradeniZahvat.specijalizacija
            zahvat = odradeniZahvat.zahvat
            stupanj = odradeniZahvat.stupanj
            binding.dnevnikNaslov.text = odradeniZahvat.datum
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
            SpecijalizantDnevnikCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        if(mentor) {
            binding.gumbObrisi.hide()
            binding.gumbUredi.hide()
        }
        webServis = WebServis()

        binding.gumbObrisi.setOnClickListener{
            webServis.obrisiOdradeniZahvat(specijalizacija!!, zahvat!!, stupanj!!){
                parent.findNavController().popBackStack()
            }
        }

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
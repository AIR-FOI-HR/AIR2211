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

    lateinit var webServis: WebServis

    inner class OdradeniZahvatiViewHolder(private val binding : SpecijalizantDnevnikCardBinding)
        : RecyclerView.ViewHolder(binding.root)
    {
        fun bind(odradeniZahvat: OdradeniZahvat) {
            binding.dnevnikNaslov.text = odradeniZahvat.datum
            binding.tipUnosaDnevnik.text = ""
            binding.gumbObrisi.setOnClickListener{
                webServis.obrisiOdradeniZahvat(odradeniZahvat.specijalizacija!!, odradeniZahvat.zahvat!!, odradeniZahvat.stupanj!!){
                    odradeniZahvatiArrayList.remove(odradeniZahvat)
                    notifyDataSetChanged()
                }
            }
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
        }
        webServis = WebServis()

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
package hr.foi.air.ednevnik.recyclerview_adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.core.entities.OdradeniDioSpecijalizacije
import com.example.ws.WebServis
import hr.foi.air.ednevnik.databinding.MentorDnevnikCardBinding
import hr.foi.air.ednevnik.databinding.SpecijalizantDnevnikCardBinding
import java.text.SimpleDateFormat

class OdradeniDijeloviSpecijalizacijeAdapter (
    private var odradeniDijeloviSpecijalizacijeArrayList: ArrayList<OdradeniDioSpecijalizacije> = arrayListOf()
) : RecyclerView.Adapter<OdradeniDijeloviSpecijalizacijeAdapter.OdradeniDijeloviSpecijalizacijeViewHolder>(){

    var onItemClick: ((OdradeniDioSpecijalizacije) -> Unit)? = null
    var mentor : Boolean = true
    var specijalizacija : Int? = null
    var dioSpecijalizacije : Int? = null

    lateinit var webServis: WebServis

    inner class OdradeniDijeloviSpecijalizacijeViewHolder(private val binding : SpecijalizantDnevnikCardBinding)
        : RecyclerView.ViewHolder(binding.root)
    {
        fun bind(odradeniDioSpecijalizacije: OdradeniDioSpecijalizacije) {
            specijalizacija = odradeniDioSpecijalizacije.specijalizacija
            dioSpecijalizacije = odradeniDioSpecijalizacije.dioSpecijalizacije
            binding.dnevnikNaslov.text = odradeniDioSpecijalizacije.trajeOd
            if(odradeniDioSpecijalizacije.trajeDo==null) { binding.tipUnosaDnevnik.text = "U trajanju" }
            else { binding.tipUnosaDnevnik.text = "do ${odradeniDioSpecijalizacije.trajeDo}"  }
        }

        init {
            itemView.setOnClickListener{
                onItemClick?.invoke(odradeniDijeloviSpecijalizacijeArrayList[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OdradeniDijeloviSpecijalizacijeViewHolder {
        val binding =
            SpecijalizantDnevnikCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        if(mentor) {binding.gumbObrisi.hide()}
        webServis = WebServis()

        binding.gumbObrisi.setOnClickListener{
            webServis.obrisiOdradeniDioSpecijalizacije(specijalizacija!!, dioSpecijalizacije!!){
                parent.findNavController().popBackStack()
            }
        }

        return OdradeniDijeloviSpecijalizacijeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OdradeniDijeloviSpecijalizacijeViewHolder, position: Int) {
        val odradeniDioSpecijalizacije = odradeniDijeloviSpecijalizacijeArrayList[position]
        holder.bind(odradeniDioSpecijalizacije)
    }

    override fun getItemCount(): Int {
        return odradeniDijeloviSpecijalizacijeArrayList.size
    }

    fun setData(newData: List<OdradeniDioSpecijalizacije>) {
        odradeniDijeloviSpecijalizacijeArrayList.clear()
        odradeniDijeloviSpecijalizacijeArrayList.addAll(newData)
        notifyDataSetChanged()
    }
}
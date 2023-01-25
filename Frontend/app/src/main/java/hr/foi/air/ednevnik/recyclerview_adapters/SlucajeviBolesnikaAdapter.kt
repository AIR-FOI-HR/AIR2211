package hr.foi.air.ednevnik.recyclerview_adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.core.entities.SlucajBolesnika
import com.example.ws.WebServis
import hr.foi.air.ednevnik.databinding.MentorDnevnikCardBinding
import hr.foi.air.ednevnik.databinding.SpecijalizantDnevnikCardBinding
import hr.foi.air.ednevnik.fragment.SpecijalizantSlucajeviBolesnikaDirections
import java.text.SimpleDateFormat

class SlucajeviBolesnikaAdapter (
    private var slucajeviBolesnikaArrayList: ArrayList<SlucajBolesnika> = arrayListOf()
) : RecyclerView.Adapter<SlucajeviBolesnikaAdapter.SlucajeviBolesnikaViewHolder>(){

    var onItemClick: ((SlucajBolesnika) -> Unit)? = null
    var mentor : Boolean = true
    var slucajId : Int? = null

    lateinit var webServis: WebServis

    inner class SlucajeviBolesnikaViewHolder(private val binding : SpecijalizantDnevnikCardBinding)
        : RecyclerView.ViewHolder(binding.root)
    {
        fun bind(slucajBolesnika: SlucajBolesnika) {
            slucajId = slucajBolesnika.idSlucaj
            Log.d("ID Sluccaj Bolesnika", slucajId.toString())
            binding.dnevnikNaslov.text = slucajBolesnika.datumSlucaj
            binding.tipUnosaDnevnik.text = slucajBolesnika.opisSlucaj
        }

        init {
            itemView.setOnClickListener{
                onItemClick?.invoke(slucajeviBolesnikaArrayList[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SlucajeviBolesnikaViewHolder {
        val binding =
            SpecijalizantDnevnikCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        if(mentor) {
            binding.gumbObrisi.hide()
            binding.gumbUredi.hide()
        }
        webServis = WebServis()

        binding.gumbObrisi.setOnClickListener{
            webServis.obrisiSlucajBolesnika(slucajId!!){
                parent.findNavController().popBackStack()
            }
        }

        return SlucajeviBolesnikaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SlucajeviBolesnikaViewHolder, position: Int) {
        val slucajBolesnika = slucajeviBolesnikaArrayList[position]
        holder.bind(slucajBolesnika)
    }

    override fun getItemCount(): Int {
        return slucajeviBolesnikaArrayList.size
    }

    fun setData(newData: List<SlucajBolesnika>) {
        slucajeviBolesnikaArrayList.clear()
        slucajeviBolesnikaArrayList.addAll(newData)
        notifyDataSetChanged()
    }
}
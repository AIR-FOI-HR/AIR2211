package hr.foi.air.ednevnik.recyclerview_adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.core.entities.StrucniRad
import com.example.ws.WebServis
import hr.foi.air.ednevnik.databinding.SpecijalizantDnevnikCardBinding

class StrucniRadoviAdapter (
    private var strucniRadoviArrayList: ArrayList<StrucniRad> = arrayListOf()
) : RecyclerView.Adapter<StrucniRadoviAdapter.StrucniRadoviViewHolder>(){

    var onItemClick: ((StrucniRad) -> Unit)? = null
    var mentor : Boolean = true
    var strucniRadId : Int? = null

    lateinit var webServis: WebServis

    inner class StrucniRadoviViewHolder(private val binding : SpecijalizantDnevnikCardBinding)
        : RecyclerView.ViewHolder(binding.root)
    {
        fun bind(strucniRad: StrucniRad) {
            strucniRadId = strucniRad.idRad
            binding.dnevnikNaslov.text = strucniRad.naslovRad
            binding.tipUnosaDnevnik.text = ""
        }

        init {
            itemView.setOnClickListener{
                onItemClick?.invoke(strucniRadoviArrayList[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StrucniRadoviViewHolder {
        val binding =
            SpecijalizantDnevnikCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        if(mentor) {binding.gumbObrisi.hide()}

        webServis = WebServis()
        binding.gumbObrisi.setOnClickListener{
            webServis.obrisiStrucniRad(strucniRadId!!){
                parent.findNavController().popBackStack()
            }
        }

        return StrucniRadoviViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StrucniRadoviViewHolder, position: Int) {
        val strucniRad = strucniRadoviArrayList[position]
        holder.bind(strucniRad)
    }

    override fun getItemCount(): Int {
        return strucniRadoviArrayList.size
    }

    fun setData(newData: List<StrucniRad>) {
        strucniRadoviArrayList.clear()
        strucniRadoviArrayList.addAll(newData)
        notifyDataSetChanged()
    }
}
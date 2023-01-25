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

    lateinit var webServis: WebServis

    inner class StrucniRadoviViewHolder(private val binding : SpecijalizantDnevnikCardBinding)
        : RecyclerView.ViewHolder(binding.root)
    {
        fun bind(strucniRad: StrucniRad) {
            binding.dnevnikNaslov.text = strucniRad.naslovRad
            binding.tipUnosaDnevnik.text = ""
            binding.gumbObrisi.setOnClickListener{
                webServis.obrisiStrucniRad(strucniRad.idRad!!){
                    strucniRadoviArrayList.remove(strucniRad)
                    notifyDataSetChanged()
                }
            }
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

        if(mentor) {
            binding.gumbObrisi.hide()
        }

        webServis = WebServis()

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
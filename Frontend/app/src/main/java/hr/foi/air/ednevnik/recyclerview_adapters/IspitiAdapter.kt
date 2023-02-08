package hr.foi.air.ednevnik.recyclerview_adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.core.entities.DnevnaAktivnost
import com.example.core.entities.Ispit
import com.example.ws.WebServis
import hr.foi.air.ednevnik.databinding.MentorDnevnikCardBinding
import hr.foi.air.ednevnik.databinding.SpecijalizantDnevnikCardBinding

class IspitiAdapter (
    private var ispitiArrayList: ArrayList<Ispit> = arrayListOf()
) : RecyclerView.Adapter<IspitiAdapter.IspitiViewHolder>(){

    var onItemClick: ((Ispit) -> Unit)? = null
    var mentor = false

    lateinit var webServis: WebServis

    inner class IspitiViewHolder(private val binding : SpecijalizantDnevnikCardBinding)
        : RecyclerView.ViewHolder(binding.root)
    {
        fun bind(ispit: Ispit) {
            binding.dnevnikNaslov.text = ispit.datum
            binding.tipUnosaDnevnik.text = ispit.nazivUstanove
            binding.gumbObrisi.setOnClickListener{
                webServis.obrisiIspit(ispit.idIspit!!){
                    ispitiArrayList.remove(ispit)
                    notifyDataSetChanged()
                }
            }
        }

        init {
            itemView.setOnClickListener{
                onItemClick?.invoke(ispitiArrayList[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IspitiViewHolder {
        val binding =
            SpecijalizantDnevnikCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        webServis = WebServis()

        if(!mentor) {
            binding.gumbObrisi.hide()
        }

        return IspitiViewHolder(binding)
    }

    override fun onBindViewHolder(holder: IspitiViewHolder, position: Int) {
        val ispit = ispitiArrayList[position]
        holder.bind(ispit)
    }

    override fun getItemCount(): Int {
        return ispitiArrayList.size
    }

    fun setData(newData: List<Ispit>) {
        ispitiArrayList.clear()
        ispitiArrayList.addAll(newData)
        notifyDataSetChanged()
    }
}
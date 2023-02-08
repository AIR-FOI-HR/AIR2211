package hr.foi.air.ednevnik.recyclerview_adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.core.entities.Specijalizant
import hr.foi.air.ednevnik.databinding.MentorListaSpecijalizantBinding

class SpecijalizantAdapter (
    private var specijalizantArrayList: ArrayList<Specijalizant> = arrayListOf()
) : RecyclerView.Adapter<SpecijalizantAdapter.SpecijalizantiViewHolder>(){

    var onItemClick: ((Specijalizant) -> Unit)? = null

    inner class SpecijalizantiViewHolder(private val binding : MentorListaSpecijalizantBinding)
        : RecyclerView.ViewHolder(binding.root)
    {
        fun bind(specijalizant: Specijalizant) {
            binding.spcijalizantIme.text = "${specijalizant.ime} ${specijalizant.prezime}"
            binding.spcijalizantTrenutniOdjel.text = specijalizant.email
        }

        init {
            itemView.setOnClickListener{
                onItemClick?.invoke(specijalizantArrayList[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecijalizantiViewHolder {
        val binding =
            MentorListaSpecijalizantBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SpecijalizantiViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SpecijalizantiViewHolder, position: Int) {
        val specijalizant = specijalizantArrayList[position]
        holder.bind(specijalizant)
    }

    override fun getItemCount(): Int {
        return specijalizantArrayList.size
    }

    fun setData(newData: List<Specijalizant>) {
        specijalizantArrayList.clear()
        specijalizantArrayList.addAll(newData)
        notifyDataSetChanged()
    }
}
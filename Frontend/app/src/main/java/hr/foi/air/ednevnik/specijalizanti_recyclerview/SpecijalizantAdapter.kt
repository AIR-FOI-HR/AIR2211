package hr.foi.air.ednevnik.specijalizanti_recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import hr.foi.air.ednevnik.R
import com.example.core.entities.Specijalizant
import hr.foi.air.ednevnik.databinding.ListaSpecijalizantBinding

class SpecijalizantAdapter (
    private var specijalizantArrayList: ArrayList<Specijalizant> = arrayListOf()
) : RecyclerView.Adapter<SpecijalizantAdapter.SpecijalizantiViewHolder>(){

    inner class SpecijalizantiViewHolder(private val binding : ListaSpecijalizantBinding)
        : RecyclerView.ViewHolder(binding.root)
    {
        fun bind(specijalizant: Specijalizant) {
            binding.spcijalizantIme.text = "${specijalizant.ime} ${specijalizant.prezime}"
            binding.spcijalizantTrenutniOdjel.text = specijalizant.email
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecijalizantiViewHolder {
        val binding =
            ListaSpecijalizantBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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
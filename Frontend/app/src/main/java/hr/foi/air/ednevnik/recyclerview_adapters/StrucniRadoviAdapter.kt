package hr.foi.air.ednevnik.recyclerview_adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.core.entities.StrucniRad
import hr.foi.air.ednevnik.databinding.MentorDnevnikCardBinding

class StrucniRadoviAdapter (
    private var strucniRadoviArrayList: ArrayList<StrucniRad> = arrayListOf()
) : RecyclerView.Adapter<StrucniRadoviAdapter.StrucniRadoviViewHolder>(){

    var onItemClick: ((StrucniRad) -> Unit)? = null

    inner class StrucniRadoviViewHolder(private val binding : MentorDnevnikCardBinding)
        : RecyclerView.ViewHolder(binding.root)
    {
        fun bind(strucniRad: StrucniRad) {
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
            MentorDnevnikCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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
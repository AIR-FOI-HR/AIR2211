package hr.foi.air.ednevnik.recyclerview_adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.core.entities.Ispit
import hr.foi.air.ednevnik.databinding.MentorDnevnikCardBinding

class IspitiAdapter (
    private var ispitiArrayList: ArrayList<Ispit> = arrayListOf()
) : RecyclerView.Adapter<IspitiAdapter.IspitiViewHolder>(){

    var onItemClick: ((Ispit) -> Unit)? = null

    inner class IspitiViewHolder(private val binding : MentorDnevnikCardBinding)
        : RecyclerView.ViewHolder(binding.root)
    {
        fun bind(ispit: Ispit) {
            binding.dnevnikNaslov.text = ispit.datum
            binding.tipUnosaDnevnik.text = ispit.nazivUstanove
        }

        init {
            itemView.setOnClickListener{
                onItemClick?.invoke(ispitiArrayList[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IspitiViewHolder {
        val binding =
            MentorDnevnikCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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
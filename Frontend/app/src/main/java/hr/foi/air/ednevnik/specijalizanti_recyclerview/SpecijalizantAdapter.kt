package hr.foi.air.ednevnik.specijalizanti_recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import hr.foi.air.ednevnik.R
import hr.foi.air.ednevnik.Specijalizant

class SpecijalizantAdapter (private val context: Context, specijalizantArrayList: ArrayList<Specijalizant>)
    : RecyclerView.Adapter<SpecijalizantAdapter.ViewHolder>(){

    val listaSpecijalizanata = specijalizantArrayList

    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        val specijalizantImePrezime : TextView = itemView.findViewById(R.id.spcijalizantIme)
        val specijalizantLokacija : TextView = itemView.findViewById(R.id.spcijalizantTrenutniOdjel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecijalizantAdapter.ViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.lista_specijalizant, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: SpecijalizantAdapter.ViewHolder, position: Int) {
        val model: Specijalizant = listaSpecijalizanata[position]
        holder.specijalizantImePrezime.text = model.ime + " " + model.prezime
        holder.specijalizantLokacija.text = model.lokacija
    }

    override fun getItemCount(): Int {
        return listaSpecijalizanata.size
    }
}
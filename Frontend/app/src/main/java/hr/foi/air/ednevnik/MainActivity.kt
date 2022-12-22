package hr.foi.air.ednevnik

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import hr.foi.air.ednevnik.specijalizanti_recyclerview.SpecijalizantAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lista_specijalizanata)

        val specijalizantiRV = findViewById<RecyclerView>(R.id.specijalizantiRecycler)

        //Hardkodirana lista specijalizanata
        val specijalizantiLista : ArrayList<com.example.core.entities.Specijalizant> = ArrayList<com.example.core.entities.Specijalizant>()
        specijalizantiLista.add(
            com.example.core.entities.Specijalizant(
                1,
                "Marko",
                "Markic",
                "",
                "Odjel dermatologije"
            )
        )
        specijalizantiLista.add(
            com.example.core.entities.Specijalizant(
                2,
                "Ivan",
                "Ivic",
                "",
                "Odjel kirurgije"
            )
        )
        specijalizantiLista.add(
            com.example.core.entities.Specijalizant(
                3,
                "Ana",
                "Anic",
                "",
                "Hitna pomoc"
            )
        )

        val specijalizantAdapter = SpecijalizantAdapter(this, specijalizantiLista)

        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        specijalizantiRV.layoutManager = linearLayoutManager
        specijalizantiRV.adapter = specijalizantAdapter
    }
}
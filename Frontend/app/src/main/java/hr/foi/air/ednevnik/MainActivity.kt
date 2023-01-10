package hr.foi.air.ednevnik

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.core.entities.Specijalizant
import com.example.ws.SpecijalizantiWebServis
import hr.foi.air.ednevnik.databinding.ActivityMainBinding
import hr.foi.air.ednevnik.fragment.SpecijalizantiFragmentDirections
import hr.foi.air.ednevnik.specijalizanti_recyclerview.SpecijalizantAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val button = findViewById<Button>(R.id.fabNovaSpecijalizacija)
    }

}
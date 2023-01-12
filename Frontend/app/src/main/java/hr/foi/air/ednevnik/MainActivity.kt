package hr.foi.air.ednevnik

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import hr.foi.air.ednevnik.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val button = findViewById<Button>(R.id.fabNovaSpecijalizacija)
    }

}
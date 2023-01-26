package hr.foi.air.ednevnik

import android.app.Notification
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.core.entities.Mentor
import com.example.core.entities.Specijalizant
import hr.foi.air.ednevnik.databinding.ActivityMainBinding
import hr.foi.air.ednevnik.fragment.ObavijestiFragment2
import hr.foi.air.ednevnik.fragment.PrikazObavijesti

class MainActivity : AppCompatActivity() {

    companion object {
        var mentor : Mentor? = null
        var specijalizant : Specijalizant? = null
        var homeAction : Int? = null
    }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM)
        supportActionBar?.setDisplayShowCustomEnabled(true)
        supportActionBar?.setCustomView(R.layout.custom_action_bar)
        val view = supportActionBar?.customView

        val backGumb = findViewById<ImageButton>(R.id.action_bar_back)
        backGumb.setOnClickListener {
            if (homeAction!=null){
                var f = supportFragmentManager.findFragmentById(R.id.host_fragment)
                f?.findNavController()?.navigate(homeAction!!)
            }
        }

        val logoutGumb = findViewById<ImageButton>(R.id.action_bar_logout)
        logoutGumb.setOnClickListener {
            var f = supportFragmentManager.findFragmentById(R.id.host_fragment)
            f?.findNavController()?.navigate(R.id.action_global_loginFragment)
        }
    }

}
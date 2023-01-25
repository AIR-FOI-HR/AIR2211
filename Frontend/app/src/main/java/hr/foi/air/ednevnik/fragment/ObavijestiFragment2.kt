package hr.foi.air.ednevnik.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView.OnDateChangeListener
import androidx.fragment.app.Fragment
import com.example.core.entities.Ispit
import hr.foi.air.ednevnik.databinding.SpecijalizantObavijestiDatumBinding
import java.text.SimpleDateFormat
import java.util.*


class ObavijestiFragment2 : Fragment(), PrikazObavijesti{
    private var _binding: SpecijalizantObavijestiDatumBinding? = null
    private val binding: SpecijalizantObavijestiDatumBinding
        get() = _binding!!

    var ispitiLista : List<Ispit>? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = SpecijalizantObavijestiDatumBinding.inflate(inflater, container, false)

        val calendar = _binding!!.calendar

        calendar.setDate(System.currentTimeMillis(), true, true)

        calendar.setOnDateChangeListener { calendarView, year, month, day ->
            val datum = Date(year-1900, month, day)
            val formatter = SimpleDateFormat("yyyy-MM-dd")
            val current = formatter.format(datum)

            Log.d("Tag", current)

            ispitiLista!!.forEach {
                if (it.datum == current) {
                    _binding!!.vrijemeIspita.text = it.vrijemeOdrzavanja
                    _binding!!.lokacijaIspita.text = it.nazivUstanove
                    if (it.prosao != null){
                        _binding!!.ocjenaIspita.text = it.prosao
                    }
                }
            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun setData(ispiti: List<Ispit>?) {
        ispitiLista = ispiti
        Log.d("Tag", ispiti.toString())
    }
}
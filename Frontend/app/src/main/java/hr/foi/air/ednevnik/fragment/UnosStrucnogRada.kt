package hr.foi.air.ednevnik.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.core.entities.SlucajBolesnika
import com.example.core.entities.StrucniRad
import com.example.ws.WebServis
import hr.foi.air.ednevnik.databinding.SpecijalizantDodajSlucajBolesnikaBinding
import hr.foi.air.ednevnik.databinding.SpecijlizantDodajStrucniRadBinding
import java.text.SimpleDateFormat
import java.util.*

class UnosStrucnogRada : Fragment() {
    private val args : UnosStrucnogRadaArgs by navArgs<UnosStrucnogRadaArgs>()
    private var _binding: SpecijlizantDodajStrucniRadBinding? = null
    private val binding: SpecijlizantDodajStrucniRadBinding
        get() = _binding!!

    lateinit var webServis: WebServis

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = SpecijlizantDodajStrucniRadBinding.inflate(inflater, container, false)

        var unesenStrucniRad = args.argStrucniRad
        var uredi = false
        if(unesenStrucniRad!=null)
        {
            uredi = true
            _binding!!.inputNaslovRada.editText?.setText(unesenStrucniRad.naslovRad)
            if(unesenStrucniRad.objavljenU!=null) { _binding!!.inputObjavljen.editText?.setText(unesenStrucniRad.objavljenU) }
        }

        _binding!!.gumbPotvrdiStrucniRad.setOnClickListener {
            val naslov = _binding!!.inputNaslovRada.editText?.text.toString()
            var objavljenU : String? = null
            if(_binding!!.inputObjavljen.editText?.text!=null && _binding!!.inputObjavljen.editText?.text.toString()!=""){
                objavljenU = _binding!!.inputObjavljen.editText?.text.toString()
            }else{
                objavljenU=null
            }


            Log.d("TAG", args.argSpecijalizacijaId)
            val idSpecijlizacije = args.argSpecijalizacijaId.toInt()

            val strucniRad = StrucniRad(null, idSpecijlizacije, naslov, objavljenU)

            if(uredi==false){
                webServis.dodajStrucniRad(strucniRad) {
                }
            } else{
                strucniRad.idRad = unesenStrucniRad!!.idRad
                webServis.urediStrucniRad(strucniRad) {
                }
            }

            val action = UnosStrucnogRadaDirections.actionUnosStrucnogRadaToSpecijalizantPracenjeSpecijlizacije()
            this.findNavController().navigate(action)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        webServis = WebServis()
    }
}
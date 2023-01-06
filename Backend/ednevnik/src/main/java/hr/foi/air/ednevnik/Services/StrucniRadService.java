package hr.foi.air.ednevnik.Services;

import hr.foi.air.ednevnik.Entities.StrucniRad;
import hr.foi.air.ednevnik.Repositories.StrucniRadRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StrucniRadService {

    private final StrucniRadRepository strucniRadRepository;

    public List<StrucniRad> StrucniRadoviBySpecijalizacija(int id){

        List<StrucniRad> strucniRadovi = new ArrayList<>();
        strucniRadovi.addAll(strucniRadRepository.findAllBySpecijalizacija(id));
        return strucniRadovi;
    }

    public Optional<StrucniRad> StrucniRadById(int id){
        Optional<StrucniRad> strucniRad = strucniRadRepository.findByIdRad(id);
        return strucniRad;
    }

    public StrucniRad AddStrucniRad(int specijalizacija, String naslovRad, String objavljenU) {
        StrucniRad strucniRad = new StrucniRad();
        strucniRad.setSpecijalizacija(specijalizacija);
        strucniRad.setNaslovRad(naslovRad);
        strucniRad.setObjavljenU(objavljenU);
        return strucniRadRepository.save(strucniRad);
    }

    public Long DeleteStrucniRad(int id) {
        if(strucniRadRepository.existsById(id))
        {
            return strucniRadRepository.deleteByIdRad(id);
        }
        else{
            return 0L;
        }

    }

    public StrucniRad UpdateStrucniRad(int id, String specijalizacija, String naslovRad, String objavljenU) {
        Optional<StrucniRad> strucniRadZaUpdate = StrucniRadById(id);
        if(strucniRadZaUpdate.isEmpty())
        {
            return null;
        }
        else{
            StrucniRad strucniRad = new StrucniRad();
            strucniRad.setIdRad(id);
            if(specijalizacija==null) { strucniRad.setSpecijalizacija(strucniRadZaUpdate.get().getSpecijalizacija()); } else{ strucniRad.setSpecijalizacija(Integer.parseInt(specijalizacija)); }
            if(naslovRad==null) { strucniRad.setNaslovRad(strucniRadZaUpdate.get().getNaslovRad()); } else{ strucniRad.setNaslovRad(naslovRad); }
            if(objavljenU==null) { strucniRad.setObjavljenU(strucniRadZaUpdate.get().getObjavljenU()); } else if(objavljenU.equals("null")){strucniRad.setObjavljenU(null);} else{ strucniRad.setObjavljenU(objavljenU); }
            return strucniRadRepository.save(strucniRad);
        }

    }
}

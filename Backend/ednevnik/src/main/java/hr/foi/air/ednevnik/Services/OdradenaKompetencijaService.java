package hr.foi.air.ednevnik.Services;

import hr.foi.air.ednevnik.Entities.OdradenaKompetencija;
import hr.foi.air.ednevnik.Repositories.OdradenaKompetencijaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OdradenaKompetencijaService {

    private final OdradenaKompetencijaRepository odradenaKompetencijaRepository;

    public List<OdradenaKompetencija> OdradeneKompetencijeBySpecijalizacija(int specijalizacija) {
        return odradenaKompetencijaRepository.findAllBySpecijalizacija(specijalizacija);
    }

    public Optional<OdradenaKompetencija> OdradenaKompetencijaByIds(int specijalizacija, int kompetencija, int stupanj){
        Optional<OdradenaKompetencija> odradenaKompetencija = odradenaKompetencijaRepository.findBySpecijalizacijaAndKompetencijaAndStupanj(specijalizacija, kompetencija, stupanj);
        return odradenaKompetencija;
    }

    public OdradenaKompetencija AddOdradenaKompetencija(OdradenaKompetencija odradenaKompetencija) { return odradenaKompetencijaRepository.save(odradenaKompetencija); }

    public Long DeleteOdradenaKompetencija(int specijalizacija, int kompetencija, int stupanj) {
        if(OdradenaKompetencijaByIds(specijalizacija, kompetencija, stupanj)!=null) { return odradenaKompetencijaRepository.deleteBySpecijalizacijaAndKompetencijaAndStupanj(specijalizacija, kompetencija, stupanj); }
        else { return 0L; }
    }

    public OdradenaKompetencija UpdateOdradenaKompetencija(OdradenaKompetencija updatedOdradenaKompetencija) {
        Optional<OdradenaKompetencija> odradenaKompetencijaZaUpdate = OdradenaKompetencijaByIds(updatedOdradenaKompetencija.getSpecijalizacija(), updatedOdradenaKompetencija.getKompetencija(), updatedOdradenaKompetencija.getStupanj());
        if(odradenaKompetencijaZaUpdate.isEmpty()) { return null; }
        else { return odradenaKompetencijaRepository.save(updatedOdradenaKompetencija); }
    }

}


package hr.foi.air.ednevnik.Services;

import hr.foi.air.ednevnik.Entities.OdradeniDioSpecijalizacije;
import hr.foi.air.ednevnik.Repositories.OdradeniDioSpecijalizacijeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OdradeniDioSpecijalizacijeService {

    private final OdradeniDioSpecijalizacijeRepository odradeniDioSpecijalizacijeRepository;

    public List<OdradeniDioSpecijalizacije> OdradeniDijeloviSpecijalizacijeBySpecijalizacija(int specijalizacija) {
        return odradeniDioSpecijalizacijeRepository.findAllBySpecijalizacija(specijalizacija);
    }

    public Optional<OdradeniDioSpecijalizacije> OdradeniDioSpecijalizacijeByIds(int specijalizacija, int dioSpecijalizacije){
        Optional<OdradeniDioSpecijalizacije> odradeniDioSpecijalizacije = odradeniDioSpecijalizacijeRepository.findBySpecijalizacijaAndAndDioSpecijalizacije(specijalizacija, dioSpecijalizacije);
        return odradeniDioSpecijalizacije;
    }

    public OdradeniDioSpecijalizacije AddOdradeniDioSpecijalizacije(OdradeniDioSpecijalizacije odradeniDioSpecijalizacije) { return odradeniDioSpecijalizacijeRepository.save(odradeniDioSpecijalizacije); }

    public Long DeleteOdradeniDioSpecijalizacije(int specijalizacija, int dioSpecijalizacije) {
        if(OdradeniDioSpecijalizacijeByIds(specijalizacija, dioSpecijalizacije)!=null) { return odradeniDioSpecijalizacijeRepository.deleteBySpecijalizacijaAndDioSpecijalizacije(specijalizacija, dioSpecijalizacije); }
        else { return 0L; }
    }

    public OdradeniDioSpecijalizacije UpdateOdradeniDioSpecijalizacije(OdradeniDioSpecijalizacije updatedOdradeniDioSpecijalizacije) {
        Optional<OdradeniDioSpecijalizacije> odradeniDioSpecijalizacijeZaUpdate = OdradeniDioSpecijalizacijeByIds(updatedOdradeniDioSpecijalizacije.getSpecijalizacija(), updatedOdradeniDioSpecijalizacije.getDioSpecijalizacije());
        if(odradeniDioSpecijalizacijeZaUpdate.isEmpty()) { return null; }
        else { return odradeniDioSpecijalizacijeRepository.save(updatedOdradeniDioSpecijalizacije); }
    }
}

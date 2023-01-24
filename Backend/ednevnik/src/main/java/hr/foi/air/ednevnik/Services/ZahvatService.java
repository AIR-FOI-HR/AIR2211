package hr.foi.air.ednevnik.Services;

import hr.foi.air.ednevnik.Entities.Kompetencija;
import hr.foi.air.ednevnik.Entities.Zahvat;
import hr.foi.air.ednevnik.Repositories.ZahvatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ZahvatService {

    private final ZahvatRepository zahvatRepository;

    public List<Zahvat> ZahvatiByProgramSpecijalizacije(int programSpecijalizacijeId) {
        return zahvatRepository.findAllByProgramSpecijalizacije(programSpecijalizacijeId);
    }

    public Integer BrojZahvataByProgramSpecijalizacije(int programSpecijalizacijeId) {
        return zahvatRepository.countAllByProgramSpecijalizacije(programSpecijalizacijeId);
    }

    public Optional<Zahvat> ZahvatById(int id){
        Optional<Zahvat> zahvat = zahvatRepository.findByIdZahvat(id);
        return zahvat;
    }
}
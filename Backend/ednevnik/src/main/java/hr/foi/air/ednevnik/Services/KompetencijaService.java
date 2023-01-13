package hr.foi.air.ednevnik.Services;


import hr.foi.air.ednevnik.Entities.Kompetencija;
import hr.foi.air.ednevnik.Repositories.KompetencijaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class KompetencijaService {

    private final KompetencijaRepository kompetencijaRepository;

    public List<Kompetencija> KompetencijeByProgramSpecijalizacije(int programSpecijalizacijeId) {
        return kompetencijaRepository.findAllByProgramSpecijalizacije(programSpecijalizacijeId);
    }

    public Integer BrojKompetencijaByProgramSpecijalizacije(int programSpecijalizacijeId) {
        return kompetencijaRepository.countAllByProgramSpecijalizacije(programSpecijalizacijeId);
    }
}

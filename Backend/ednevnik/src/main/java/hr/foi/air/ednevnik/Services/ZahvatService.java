package hr.foi.air.ednevnik.Services;

import hr.foi.air.ednevnik.Entities.Zahvat;
import hr.foi.air.ednevnik.Repositories.ZahvatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
}

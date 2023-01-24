package hr.foi.air.ednevnik.Services;

import hr.foi.air.ednevnik.Entities.DioSpecijalizacije;
import hr.foi.air.ednevnik.Entities.Kompetencija;
import hr.foi.air.ednevnik.Repositories.DioSpecijalizacijeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DioSpecijalizacijeService {

    private final DioSpecijalizacijeRepository dioSpecijalizacijeRepository;

    public List<DioSpecijalizacije> DijeloviSpecijalizacijeByProgramSpecijalizacije(int programSpecijalizacijeId) {
        return dioSpecijalizacijeRepository.findAllByProgramSpecijalizacije(programSpecijalizacijeId);
    }

    public Integer BrojDijelovaSpecijalizacijeByProgramSpecijalizacije(int programSpecijalizacijeId) {
        return dioSpecijalizacijeRepository.countAllByProgramSpecijalizacije(programSpecijalizacijeId);
    }

    public Optional<DioSpecijalizacije> DioSpecijalizacijeById(int id){
        Optional<DioSpecijalizacije> dioSpecijalizacije = dioSpecijalizacijeRepository.findByIdDioSpecjalizacije(id);
        return dioSpecijalizacije;
    }
}

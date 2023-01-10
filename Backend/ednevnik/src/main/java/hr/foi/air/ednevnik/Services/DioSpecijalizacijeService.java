package hr.foi.air.ednevnik.Services;

import hr.foi.air.ednevnik.Entities.DioSpecijalizacije;
import hr.foi.air.ednevnik.Repositories.DioSpecijalizacijeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DioSpecijalizacijeService {

    private final DioSpecijalizacijeRepository dioSpecijalizacijeRepository;

    public List<DioSpecijalizacije> DijeloviSpecijalizacijeByProgramSpecijalizacije(int programSpecijalizacijeId) {
        return dioSpecijalizacijeRepository.findAllByProgramSpecijalizacije(programSpecijalizacijeId);
    }
}

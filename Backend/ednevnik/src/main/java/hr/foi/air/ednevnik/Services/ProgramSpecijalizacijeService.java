package hr.foi.air.ednevnik.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProgramSpecijalizacijeService {

    private final ZahvatService zahvatService;
    private final KompetencijaService kompetencijaService;
    private final DioSpecijalizacijeService dioSpecijalizacijeService;

    public Integer BrojUvjetaById(int programSpecijalizacijeId) {
        Integer brojUvjeta = 0;
        brojUvjeta += zahvatService.BrojZahvataByProgramSpecijalizacije(programSpecijalizacijeId);
        brojUvjeta += kompetencijaService.BrojKompetencijaByProgramSpecijalizacije(programSpecijalizacijeId);
        brojUvjeta += dioSpecijalizacijeService.BrojDijelovaSpecijalizacijeByProgramSpecijalizacije(programSpecijalizacijeId);
        return brojUvjeta;
    }
}

package hr.foi.air.ednevnik.Controllers;

import hr.foi.air.ednevnik.Entities.DioSpecijalizacije;
import hr.foi.air.ednevnik.Services.DioSpecijalizacijeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/dijelovi_specijalizacije")
public class DioSpecijalizacijeController {

    private DioSpecijalizacijeService dioSpecijalizacijeService;

    @GetMapping("/getAllByProgramSpecijalizacijeId/{program_specijalizacije_id}")
    public ResponseEntity<List<DioSpecijalizacije>> GetDijeloviSpecijalizacijeByProgramSpecijalizacije(@PathVariable int program_specijalizacije_id) {
        var dijeloviSpecijalizacije = dioSpecijalizacijeService.DijeloviSpecijalizacijeByProgramSpecijalizacije(program_specijalizacije_id);
        try {
            if (dijeloviSpecijalizacije.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            } else return new ResponseEntity<>(dijeloviSpecijalizacije, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getCountByProgramSpecijalizacijeId/{program_specijalizacije_id}")
    public ResponseEntity<Integer> GetBrojDijelovaKompetencijeByProgramSpecijalizacije(@PathVariable int program_specijalizacije_id) {
        var brojDijelovaSpecijalizacije = dioSpecijalizacijeService.BrojDijelovaSpecijalizacijeByProgramSpecijalizacije(program_specijalizacije_id);
        try {
            if (brojDijelovaSpecijalizacije == null) {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            } else return new ResponseEntity<>(brojDijelovaSpecijalizacije, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}

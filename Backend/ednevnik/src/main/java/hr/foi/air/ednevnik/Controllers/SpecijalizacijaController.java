package hr.foi.air.ednevnik.Controllers;

import hr.foi.air.ednevnik.Entities.Specijalizacija;
import hr.foi.air.ednevnik.Entities.Specijalizant;
import hr.foi.air.ednevnik.Services.SpecijalizacijaService;
import hr.foi.air.ednevnik.Services.SpecijalizantService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/specijalizacija")
public class SpecijalizacijaController {

    private SpecijalizacijaService specijalizacijaService;

    @GetMapping("/getAllBySpecijalizantId/{id_specijalizant}")
    public ResponseEntity<List<Specijalizacija>> GetSpecijalizacijeBySpecijalizantId(@PathVariable int id_specijalizant){
        var specijalizacije = specijalizacijaService.sveSpecijalizacijeBySpecijalizantId(id_specijalizant);
        try{
            if(specijalizacije==null){
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            else
                return new ResponseEntity<>(specijalizacije, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getActiveBySpecijalizantId/{id_specijalizant}")
    public ResponseEntity<Optional<Specijalizacija>> GetAktivnaSpecijalizacijaBySpecijalizantId(@PathVariable int id_specijalizant){
        var specijalizacija = specijalizacijaService.aktivnaSpecijalizacijaBySpecijalizantId(id_specijalizant);
        try{
            if(specijalizacija==null){
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            else
                return new ResponseEntity<>(specijalizacija, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Optional<Specijalizacija>> GetSpecijalizacijaById(@PathVariable int id){
        var specijalizacija = specijalizacijaService.specijalizacijaById(id);
        try{
            if(specijalizacija==null){
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            else
                return new ResponseEntity<>(specijalizacija, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}

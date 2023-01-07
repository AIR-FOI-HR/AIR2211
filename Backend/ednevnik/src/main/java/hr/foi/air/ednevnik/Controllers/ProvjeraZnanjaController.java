package hr.foi.air.ednevnik.Controllers;

import hr.foi.air.ednevnik.Entities.ProvjeraZnanja;
import hr.foi.air.ednevnik.Services.ProvjeraZnanjaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/provjere_znanja")
public class ProvjeraZnanjaController {

    private ProvjeraZnanjaService provjeraZnanjaService;

    @GetMapping("/getAllBySpecijalizacijaId/{specijalizacija_id}")
    public ResponseEntity<List<ProvjeraZnanja>> GetProvjereZnanjaBySpecijalizacija(@PathVariable int specijalizacija_id){
        var provjereZnanja = provjeraZnanjaService.ProvjereZnanjaBySpecijalizacija(specijalizacija_id);
        try{
            if(provjereZnanja.isEmpty()){
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            else
                return new ResponseEntity<>(provjereZnanja, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Optional<ProvjeraZnanja>> GetProvjeraZnanjaById(@PathVariable int id){
        var provjeraZnanja = provjeraZnanjaService.ProvjeraZnanjaById(id);
        try{
            if(provjeraZnanja.isEmpty()){
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            else
                return new ResponseEntity<>(provjeraZnanja, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}

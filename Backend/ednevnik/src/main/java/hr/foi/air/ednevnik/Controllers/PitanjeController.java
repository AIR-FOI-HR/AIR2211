package hr.foi.air.ednevnik.Controllers;

import hr.foi.air.ednevnik.Entities.*;
import hr.foi.air.ednevnik.Services.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/pitanja")
public class PitanjeController {

    private PitanjeService pitanjeService;

    @GetMapping("/getAllByProvjeraId/{provjera_id}")
    public ResponseEntity<List<Pitanje>> GetPitanjaByProvjeraZnanja(@PathVariable int provjera_id){
        var pitanja = pitanjeService.PitanjaByProvjeraZnanja(provjera_id);
        try{
            if(pitanja==null){
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            else
                return new ResponseEntity<>(pitanja, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Optional<Pitanje>> GetPitanjeById(@PathVariable int id){
        var pitanje = pitanjeService.ProvjeraZnanjaById(id);
        try{
            if(pitanje==null){
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            else
                return new ResponseEntity<>(pitanje, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}

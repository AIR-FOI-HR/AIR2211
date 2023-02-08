package hr.foi.air.ednevnik.Controllers;

import hr.foi.air.ednevnik.Entities.Pitanje;
import hr.foi.air.ednevnik.Services.PitanjeService;
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
    public ResponseEntity<List<Pitanje>> GetPitanjaByProvjeraZnanja(@PathVariable int provjera_id) {
        var pitanja = pitanjeService.PitanjaByProvjeraZnanja(provjera_id);
        try {
            if (pitanja.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            } else return new ResponseEntity<>(pitanja, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Optional<Pitanje>> GetPitanjeById(@PathVariable int id) {
        var pitanje = pitanjeService.PitanjeById(id);
        try {
            if (pitanje.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            } else return new ResponseEntity<>(pitanje, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping("/add")
    @ResponseBody
    public ResponseEntity<Pitanje> AddPitanje(@RequestBody Pitanje pitanje) {
        try {
            pitanjeService.AddPitanje(pitanje);
            return new ResponseEntity<>(pitanje, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> DeletePitanje(@PathVariable int id) {
        try {
            Long odgovor = pitanjeService.DeletePitanje(id);
            if (odgovor == 0L) {
                return new ResponseEntity<>(odgovor, HttpStatus.BAD_REQUEST);
            } else {
                return new ResponseEntity<>(odgovor, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(0L, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping("/update")
    @ResponseBody
    public ResponseEntity<Pitanje> UpdatePitanje(@RequestBody Pitanje pitanje) {
        try {
            Pitanje odgovor = pitanjeService.UpdatePitanje(pitanje);
            if (odgovor == null) {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            } else {
                return new ResponseEntity<>(pitanje, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}

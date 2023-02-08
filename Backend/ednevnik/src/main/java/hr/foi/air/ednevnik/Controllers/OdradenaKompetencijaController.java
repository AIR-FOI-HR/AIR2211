package hr.foi.air.ednevnik.Controllers;

import hr.foi.air.ednevnik.Entities.OdradenaKompetencija;
import hr.foi.air.ednevnik.Services.OdradenaKompetencijaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/odradene_kompetencije")
public class OdradenaKompetencijaController {

    private OdradenaKompetencijaService odradenaKompetencijaService;

    @GetMapping("/getAllBySpecijalizacija/{specijalizacija_id}")
    public ResponseEntity<List<OdradenaKompetencija>> GetOdradeneKompetencijeBySpecijalizacija(@PathVariable int specijalizacija_id) {
        var odradeneKompetencije = odradenaKompetencijaService.OdradeneKompetencijeBySpecijalizacija(specijalizacija_id);
        try {
            if (odradeneKompetencije.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            } else return new ResponseEntity<>(odradeneKompetencije, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getByIds")
    public ResponseEntity<Optional<OdradenaKompetencija>> GetOdradenaKompetencijaByIds(@RequestParam int specijalizacija, @RequestParam int kompetencija, @RequestParam int stupanj) {
        var odradenaKompetencija = odradenaKompetencijaService.OdradenaKompetencijaByIds(specijalizacija, kompetencija, stupanj);
        try {
            if (odradenaKompetencija.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            } else return new ResponseEntity<>(odradenaKompetencija, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping("/add")
    @ResponseBody
    public ResponseEntity<OdradenaKompetencija> AddOdradenaKompetencija(@RequestBody OdradenaKompetencija odradenaKompetencija) {
        try {
            odradenaKompetencijaService.AddOdradenaKompetencija(odradenaKompetencija);
            return new ResponseEntity<>(odradenaKompetencija, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Long> DeleteOdradenaKompetencija(@RequestParam int specijalizacija, @RequestParam int kompetencija, @RequestParam int stupanj) {
        try {
            Long odgovor = odradenaKompetencijaService.DeleteOdradenaKompetencija(specijalizacija, kompetencija, stupanj);
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
    public ResponseEntity<OdradenaKompetencija> UpdateOdradenaKompetencija(@RequestBody OdradenaKompetencija odradenaKompetencija) {
        try {
            OdradenaKompetencija odgovor = odradenaKompetencijaService.UpdateOdradenaKompetencija(odradenaKompetencija);
            if (odgovor == null) {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            } else {
                return new ResponseEntity<>(odradenaKompetencija, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
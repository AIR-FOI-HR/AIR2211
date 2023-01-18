package hr.foi.air.ednevnik.Controllers;


import hr.foi.air.ednevnik.Entities.Ispit;
import hr.foi.air.ednevnik.Entities.Kompetencija;
import hr.foi.air.ednevnik.Services.KompetencijaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/kompetencije")
public class KompetencijaController {

    private KompetencijaService kompetencijaService;

    @GetMapping("/getAllByProgramSpecijalizacijeId/{program_specijalizacije_id}")
    public ResponseEntity<List<Kompetencija>> GetKompetencijeByProgramSpecijalizacije(@PathVariable int program_specijalizacije_id){
        var kompetencije = kompetencijaService.KompetencijeByProgramSpecijalizacije(program_specijalizacije_id);
        try{
            if(kompetencije.isEmpty()){
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            else
                return new ResponseEntity<>(kompetencije, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getCountByProgramSpecijalizacijeId/{program_specijalizacije_id}")
    public ResponseEntity<Integer> GetBrojKompetencijaByProgramSpecijalizacije(@PathVariable int program_specijalizacije_id){
        var brojKompetencija = kompetencijaService.BrojKompetencijaByProgramSpecijalizacije(program_specijalizacije_id);
        try{
            if(brojKompetencija==null){
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            else
                return new ResponseEntity<>(brojKompetencija, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<Optional<Kompetencija>> GetKompetencijaById(@PathVariable int id){
        var kompetencija = kompetencijaService.KompetencijaById(id);
        try{
            if(kompetencija.isEmpty()){
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            else
                return new ResponseEntity<>(kompetencija, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}

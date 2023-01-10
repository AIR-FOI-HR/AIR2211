package hr.foi.air.ednevnik.Controllers;


import hr.foi.air.ednevnik.Entities.Kompetencija;
import hr.foi.air.ednevnik.Services.KompetencijaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
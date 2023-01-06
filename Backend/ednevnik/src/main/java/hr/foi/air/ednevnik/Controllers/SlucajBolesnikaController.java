package hr.foi.air.ednevnik.Controllers;

import hr.foi.air.ednevnik.Entities.SlucajBolesnika;
import hr.foi.air.ednevnik.Entities.Specijalizant;
import hr.foi.air.ednevnik.Entities.StrucniRad;
import hr.foi.air.ednevnik.Services.SlucajBolesnikaService;
import hr.foi.air.ednevnik.Services.SpecijalizantService;
import hr.foi.air.ednevnik.Services.StrucniRadService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/slucajevi_bolesnika")
public class SlucajBolesnikaController {

    private SlucajBolesnikaService slucajBolesnikaService;

    @GetMapping("/getAllBySpecijalizacijaId/{specijalizacija_id}")
    public ResponseEntity<List<SlucajBolesnika>> GetSlucajeviBolesnikaBySpecijalizacija(@PathVariable int specijalizacija_id){
        var slucajevi_bolesnika = slucajBolesnikaService.SlucajeviBolesnikaBySpecijalizacija(specijalizacija_id);
        try{
            if(slucajevi_bolesnika==null){
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            else
                return new ResponseEntity<>(slucajevi_bolesnika, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Optional<SlucajBolesnika>> GetSlucajBolesnikaById(@PathVariable int id){
        var slucaj_bolesnika = slucajBolesnikaService.SlucajBolesnikaById(id);
        try{
            if(slucaj_bolesnika==null){
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            else
                return new ResponseEntity<>(slucaj_bolesnika, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}

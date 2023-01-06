package hr.foi.air.ednevnik.Controllers;

import hr.foi.air.ednevnik.Entities.SlucajBolesnika;
import hr.foi.air.ednevnik.Services.SlucajBolesnikaService;
import lombok.AllArgsConstructor;
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
        var slucajeviBolesnika = slucajBolesnikaService.SlucajeviBolesnikaBySpecijalizacija(specijalizacija_id);
        try{
            if(slucajeviBolesnika==null){
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            else
                return new ResponseEntity<>(slucajeviBolesnika, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Optional<SlucajBolesnika>> GetSlucajBolesnikaById(@PathVariable int id){
        var slucajBolesnika = slucajBolesnikaService.SlucajBolesnikaById(id);
        try{
            if(slucajBolesnika==null){
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            else
                return new ResponseEntity<>(slucajBolesnika, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
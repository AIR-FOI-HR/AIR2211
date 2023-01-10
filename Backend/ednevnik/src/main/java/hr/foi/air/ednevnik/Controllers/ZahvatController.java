package hr.foi.air.ednevnik.Controllers;

import hr.foi.air.ednevnik.Entities.Zahvat;
import hr.foi.air.ednevnik.Services.ZahvatService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/zahvati")
public class ZahvatController {

    private ZahvatService zahvatService;

    @GetMapping("/getAllByProgramSpecijalizacijeId/{program_specijalizacije_id}")
    public ResponseEntity<List<Zahvat>> GetZahvatiByProgramSpecijalizacije(@PathVariable int program_specijalizacije_id){
        var zahvati = zahvatService.ZahvatiByProgramSpecijalizacije(program_specijalizacije_id);
        try{
            if(zahvati.isEmpty()){
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            else
                return new ResponseEntity<>(zahvati, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
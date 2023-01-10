package hr.foi.air.ednevnik.Controllers;

import hr.foi.air.ednevnik.Entities.StupanjNapredovanja;
import hr.foi.air.ednevnik.Services.StupanjNapredovanjaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/stupnjevi_napredovanja")
public class StupanjNapredovanjaController {

    private StupanjNapredovanjaService stupanjNapredovanjaService;

    @GetMapping("/getById/{id}")
    public ResponseEntity<Optional<StupanjNapredovanja>> GetStupanjNapredovanjaById(@PathVariable int id){
        var stupanjNapredovanja = stupanjNapredovanjaService.StupanjNapredovanjaById(id);
        try{
            if(stupanjNapredovanja.isEmpty()){
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            else
                return new ResponseEntity<>(stupanjNapredovanja, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}

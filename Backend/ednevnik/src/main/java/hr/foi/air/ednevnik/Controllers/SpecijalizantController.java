package hr.foi.air.ednevnik.Controllers;

import hr.foi.air.ednevnik.Entities.Specijalizant;
import hr.foi.air.ednevnik.Services.SpecijalizantService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/specijalizanti")
public class SpecijalizantController {

    private SpecijalizantService specijalizantService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Specijalizant>> GetSpecijalizanti(){
        var specijalizanti = specijalizantService.SviSpecijalizanti();
        try{
            if(specijalizanti.isEmpty()){
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            else
                return new ResponseEntity<>(specijalizanti, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Optional<Specijalizant>> GetSpecijalizantById(@PathVariable int id){
        var specijalizant = specijalizantService.SpecijalizantById(id);
        try{
            if(specijalizant.isEmpty()){
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            else
                return new ResponseEntity<>(specijalizant, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/getAllByMentor/{id_mentor}")
    public ResponseEntity<List<Specijalizant>> GetSpecijalizantiByMentor(@PathVariable int id_mentor){
        var specijalizanti = specijalizantService.SpecijalizantiByMentor(id_mentor);
        try{
            if(specijalizanti.isEmpty()){
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            else
                return new ResponseEntity<>(specijalizanti, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}

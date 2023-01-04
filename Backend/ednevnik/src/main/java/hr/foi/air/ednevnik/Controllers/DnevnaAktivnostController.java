package hr.foi.air.ednevnik.Controllers;

import hr.foi.air.ednevnik.Entities.DnevnaAktivnost;
import hr.foi.air.ednevnik.Entities.Specijalizant;
import hr.foi.air.ednevnik.Services.DnevnaAktivnostService;
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
@RequestMapping("/dnevne_aktivnosti")
public class DnevnaAktivnostController {

    private DnevnaAktivnostService dnevnaAktivnostService;

    @GetMapping("/getAllBySpecijalizacijaId/{specijalizacija_id}")
    public ResponseEntity<List<DnevnaAktivnost>> GetAktivnosti(@PathVariable int specijalizacija_id){
        var aktivnosti = dnevnaAktivnostService.sveAktivnosti(specijalizacija_id);
        try{
            if(aktivnosti.isEmpty()){
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            else
                return new ResponseEntity<>(aktivnosti, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Optional<DnevnaAktivnost>> GetAktivnostById(@PathVariable int id){
        var aktivnost = dnevnaAktivnostService.dnevnaAktivnostById(id);
        try{
            if(aktivnost==null){
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            else
                return new ResponseEntity<>(aktivnost, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}

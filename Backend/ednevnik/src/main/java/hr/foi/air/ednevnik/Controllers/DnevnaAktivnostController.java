package hr.foi.air.ednevnik.Controllers;

import hr.foi.air.ednevnik.Entities.DnevnaAktivnost;
import hr.foi.air.ednevnik.Services.DnevnaAktivnostService;
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
    public ResponseEntity<List<DnevnaAktivnost>> GetAktivnostiBySpecijalizacija(@PathVariable int specijalizacija_id){
        var dnevneAktivnosti = dnevnaAktivnostService.DnevneAktivnostiBySpecijalizacija(specijalizacija_id);
        try{
            if(dnevneAktivnosti.isEmpty()){
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            else
                return new ResponseEntity<>(dnevneAktivnosti, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Optional<DnevnaAktivnost>> GetAktivnostById(@PathVariable int id){
        var dnevnaAktivnost = dnevnaAktivnostService.DnevnaAktivnostById(id);
        try{
            if(dnevnaAktivnost.isEmpty()){
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            else
                return new ResponseEntity<>(dnevnaAktivnost, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}

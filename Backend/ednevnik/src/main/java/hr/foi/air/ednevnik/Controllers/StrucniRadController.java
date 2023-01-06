package hr.foi.air.ednevnik.Controllers;

import hr.foi.air.ednevnik.Entities.StrucniRad;
import hr.foi.air.ednevnik.Services.StrucniRadService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/strucni_radovi")
public class StrucniRadController {

    private StrucniRadService strucniRadService;

    @GetMapping("/getAllBySpecijalizacijaId/{specijalizacija_id}")
    public ResponseEntity<List<StrucniRad>> GetStrucniRadoviBySpecijalizacija(@PathVariable int specijalizacija_id){
        var strucniRadovi = strucniRadService.StrucniRadoviBySpecijalizacija(specijalizacija_id);
        try{
            if(strucniRadovi==null){
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            else
                return new ResponseEntity<>(strucniRadovi, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Optional<StrucniRad>> GetStrucniRadById(@PathVariable int id){
        var strucniRad = strucniRadService.StrucniRadById(id);
        try{
            if(strucniRad==null){
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            else
                return new ResponseEntity<>(strucniRad, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
package hr.foi.air.ednevnik.Controllers;

import hr.foi.air.ednevnik.Entities.Specijalizant;
import hr.foi.air.ednevnik.Entities.StrucniRad;
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
@RequestMapping("/strucni_radovi")
public class StrucniRadController {

    private StrucniRadService strucniRadService;

    @GetMapping("/getAllBySpecijalizacijaId/{specijalizacija_id}")
    public ResponseEntity<List<StrucniRad>> GetStrucniRadovi(@PathVariable int specijalizacija_id){
        var strucni_radovi = strucniRadService.sviStrucniRadovi(specijalizacija_id);
        try{
            if(strucni_radovi==null){
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            else
                return new ResponseEntity<>(strucni_radovi, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Optional<StrucniRad>> GetStrucniRadById(@PathVariable int id){
        var strucni_rad = strucniRadService.strucniRadById(id);
        try{
            if(strucni_rad==null){
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            else
                return new ResponseEntity<>(strucni_rad, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}

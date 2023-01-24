package hr.foi.air.ednevnik.Controllers;


import hr.foi.air.ednevnik.Entities.UstrojstvenaJedinica;
import hr.foi.air.ednevnik.Services.UstrojstvenaJedinicaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/ustrojstvene_jedinice")
public class UstrojstvenaJedinicaController {

    private UstrojstvenaJedinicaService ustrojstvenaJedinicaService;

    @GetMapping("/getById/{id}")
    public ResponseEntity<Optional<UstrojstvenaJedinica>> GetUstrojstvenaJedinicaById(@PathVariable int id){
        var ustrojstvenaJedinica = ustrojstvenaJedinicaService.UstrojstvenaJedinicaById(id);
        try{
            if(ustrojstvenaJedinica.isEmpty()){
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            else
                return new ResponseEntity<>(ustrojstvenaJedinica, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getCurrentBySpecijalizantId/{specijalizant_id}")
    public ResponseEntity<Optional<UstrojstvenaJedinica>> GetCurrentUstrojstvenaJedinicaBySpecijalizantId(@PathVariable int specijalizant_id){
        var ustrojstvenaJedinica = ustrojstvenaJedinicaService.TrenutnaUstrojstvenaJedinicaSpecijalizantaBySpecijalizantId(specijalizant_id);
        try{
            if(ustrojstvenaJedinica.isEmpty()){
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            else
                return new ResponseEntity<>(ustrojstvenaJedinica, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}

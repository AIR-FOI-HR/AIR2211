package hr.foi.air.ednevnik.Controllers;

import hr.foi.air.ednevnik.Entities.Specijalizacija;
import hr.foi.air.ednevnik.Services.SpecijalizacijaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/specijalizacija")
public class SpecijalizacijaController {

    private SpecijalizacijaService specijalizacijaService;

    @GetMapping("/getAllBySpecijalizantId/{id_specijalizant}")
    public ResponseEntity<List<Specijalizacija>> GetSpecijalizacijeBySpecijalizantId(@PathVariable int id_specijalizant){
        var specijalizacije = specijalizacijaService.SpecijalizacijeBySpecijalizantId(id_specijalizant);
        try{
            if(specijalizacije.isEmpty()){
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            else
                return new ResponseEntity<>(specijalizacije, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getActiveBySpecijalizantId/{id_specijalizant}")
    public ResponseEntity<Optional<Specijalizacija>> GetAktivnaSpecijalizacijaBySpecijalizantId(@PathVariable int id_specijalizant){
        var specijalizacija = specijalizacijaService.AktivnaSpecijalizacijaBySpecijalizantId(id_specijalizant);
        try{
            if(specijalizacija.isEmpty()){
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            else
                return new ResponseEntity<>(specijalizacija, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Optional<Specijalizacija>> GetSpecijalizacijaById(@PathVariable int id){
        var specijalizacija = specijalizacijaService.SpecijalizacijaById(id);
        try{
            if(specijalizacija.isEmpty()){
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            else
                return new ResponseEntity<>(specijalizacija, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping("/add")
    @ResponseBody
    public ResponseEntity<Specijalizacija> AddSpecijalizacija(@RequestBody Specijalizacija specijalizacija){
        try{
            specijalizacijaService.AddSpecijalizacija(specijalizacija);
            return new ResponseEntity<>(specijalizacija, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> DeleteSpecijalizacija(@PathVariable int id){
        try{
            Long odgovor = specijalizacijaService.DeleteSpecijalizacija(id);
            if(odgovor==0L) {return new ResponseEntity<>(odgovor, HttpStatus.BAD_REQUEST);}
            else {return new ResponseEntity<>(odgovor, HttpStatus.OK);}
        }catch (Exception e){
            return new ResponseEntity<>(0L, HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping("/update")
    @ResponseBody
    public ResponseEntity<Specijalizacija> UpdateSpecijalizacija(@RequestBody Specijalizacija specijalizacija){
        try{
            Specijalizacija odgovor = specijalizacijaService.UpdateSpecijalizacija(specijalizacija);
            if(odgovor==null) {return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);}
            else {return new ResponseEntity<>(specijalizacija, HttpStatus.OK);}
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}

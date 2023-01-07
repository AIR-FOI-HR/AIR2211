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
            if(slucajeviBolesnika.isEmpty()){
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
            if(slucajBolesnika.isEmpty()){
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            else
                return new ResponseEntity<>(slucajBolesnika, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping("/add")
    @ResponseBody
    public ResponseEntity<SlucajBolesnika> AddSlucajBolesnika(@RequestBody SlucajBolesnika slucajBolesnika){
        try{
            slucajBolesnikaService.AddSlucajBolesnika(slucajBolesnika);
            return new ResponseEntity<>(slucajBolesnika, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> DeleteSlucajBolesnika(@PathVariable int id){
        try{
            Long odgovor = slucajBolesnikaService.DeleteSlucajBolesnika(id);
            if(odgovor==0L) {return new ResponseEntity<>(odgovor, HttpStatus.BAD_REQUEST);}
            else {return new ResponseEntity<>(odgovor, HttpStatus.OK);}
        }catch (Exception e){
            return new ResponseEntity<>(0L, HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping("/update")
    @ResponseBody
    public ResponseEntity<SlucajBolesnika> UpdateSlucajBolesnika(@RequestBody SlucajBolesnika slucajBolesnika){
        try{
            SlucajBolesnika odgovor = slucajBolesnikaService.UpdateSlucajBolesnika(slucajBolesnika);
            if(odgovor==null) {return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);}
            else {return new ResponseEntity<>(slucajBolesnika, HttpStatus.OK);}
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}

package hr.foi.air.ednevnik.Controllers;

import hr.foi.air.ednevnik.Entities.OdradeniZahvat;
import hr.foi.air.ednevnik.Services.OdradeniZahvatService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/odradeni_zahvati")
public class OdradeniZahvatController {

    private OdradeniZahvatService odradeniZahvatService;

    @GetMapping("/getAllBySpecijalizacija/{specijalizacija_id}")
    public ResponseEntity<List<OdradeniZahvat>> GetOdradeniZahvatiBySpecijalizacija(@PathVariable int specijalizacija_id){
        var odradeniZahvati = odradeniZahvatService.OdradeniZahvatiBySpecijalizacija(specijalizacija_id);
        try{
            if(odradeniZahvati.isEmpty()){
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            else
                return new ResponseEntity<>(odradeniZahvati, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getByIds")
    public ResponseEntity<Optional<OdradeniZahvat>> GetOdradeniZahvatByIds(@RequestParam int specijalizacija, @RequestParam int zahvat, @RequestParam int stupanj){
        var odradeniZahvat = odradeniZahvatService.OdradeniZahvatByIds(specijalizacija, zahvat, stupanj);
        try{
            if(odradeniZahvat.isEmpty()){
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            else
                return new ResponseEntity<>(odradeniZahvat, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping("/add")
    @ResponseBody
    public ResponseEntity<OdradeniZahvat> AddOdradeniZahvat(@RequestBody OdradeniZahvat odradeniZahvat){
        try{
            odradeniZahvatService.AddOdradeniZahvat(odradeniZahvat);
            return new ResponseEntity<>(odradeniZahvat, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Long> DeleteOdradeniZahvat(@RequestParam int specijalizacija, @RequestParam int zahvat, @RequestParam int stupanj){
        try{
            Long odgovor = odradeniZahvatService.DeleteOdradeniZahvat(specijalizacija, zahvat, stupanj);
            if(odgovor==0L) {return new ResponseEntity<>(odgovor, HttpStatus.BAD_REQUEST);}
            else {return new ResponseEntity<>(odgovor, HttpStatus.OK);}
        }catch (Exception e){
            return new ResponseEntity<>(0L, HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping("/update")
    @ResponseBody
    public ResponseEntity<OdradeniZahvat> UpdateOdradeniZahvat(@RequestBody OdradeniZahvat odradeniZahvat){
        try{
            OdradeniZahvat odgovor = odradeniZahvatService.UpdateOdradeniZahvat(odradeniZahvat);
            if(odgovor==null) {return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);}
            else {return new ResponseEntity<>(odradeniZahvat, HttpStatus.OK);}
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}

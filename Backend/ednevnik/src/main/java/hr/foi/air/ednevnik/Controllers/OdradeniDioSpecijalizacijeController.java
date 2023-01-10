package hr.foi.air.ednevnik.Controllers;

import hr.foi.air.ednevnik.Entities.OdradeniDioSpecijalizacije;
import hr.foi.air.ednevnik.Services.OdradeniDioSpecijalizacijeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/odradeni_dijelovi_specijalizacije")
public class OdradeniDioSpecijalizacijeController {

    private OdradeniDioSpecijalizacijeService odradeniDioSpecijalizacijeService;

    @GetMapping("/getAllBySpecijalizacija/{specijalizacija_id}")
    public ResponseEntity<List<OdradeniDioSpecijalizacije>> GetOdradeniDijeloviSpecijalizacijeBySpecijalizacija(@PathVariable int specijalizacija_id){
        var odradeniDijeloviSpecijalizacije = odradeniDioSpecijalizacijeService.OdradeniDijeloviSpecijalizacijeBySpecijalizacija(specijalizacija_id);
        try{
            if(odradeniDijeloviSpecijalizacije.isEmpty()){
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            else
                return new ResponseEntity<>(odradeniDijeloviSpecijalizacije, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getByIds")
    public ResponseEntity<Optional<OdradeniDioSpecijalizacije>> GetOdradeniDioSpecijalizacijeByIds(@RequestParam int specijalizacija, @RequestParam int dioSpecijalizacije){
        var odradeniDioSpecijalizacije = odradeniDioSpecijalizacijeService.OdradeniDioSpecijalizacijeByIds(specijalizacija, dioSpecijalizacije);
        try{
            if(odradeniDioSpecijalizacije.isEmpty()){
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            else
                return new ResponseEntity<>(odradeniDioSpecijalizacije, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping("/add")
    @ResponseBody
    public ResponseEntity<OdradeniDioSpecijalizacije> AddOdradeniDioSpecijalizacije(@RequestBody OdradeniDioSpecijalizacije odradeniDioSpecijalizacije){
        try{
            odradeniDioSpecijalizacijeService.AddOdradeniDioSpecijalizacije(odradeniDioSpecijalizacije);
            return new ResponseEntity<>(odradeniDioSpecijalizacije, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Long> DeleteOdradeniDioSpecijalizacije(@RequestParam int specijalizacija, @RequestParam int dioSpecijalizacije){
        try{
            Long odgovor = odradeniDioSpecijalizacijeService.DeleteOdradeniDioSpecijalizacije(specijalizacija, dioSpecijalizacije);
            if(odgovor==0L) {return new ResponseEntity<>(odgovor, HttpStatus.BAD_REQUEST);}
            else {return new ResponseEntity<>(odgovor, HttpStatus.OK);}
        }catch (Exception e){
            return new ResponseEntity<>(0L, HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping("/update")
    @ResponseBody
    public ResponseEntity<OdradeniDioSpecijalizacije> UpdateOdradeniDioSpecijalizacije(@RequestBody OdradeniDioSpecijalizacije odradeniDioSpecijalizacije){
        try{
            OdradeniDioSpecijalizacije odgovor = odradeniDioSpecijalizacijeService.UpdateOdradeniDioSpecijalizacije(odradeniDioSpecijalizacije);
            if(odgovor==null) {return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);}
            else {return new ResponseEntity<>(odradeniDioSpecijalizacije, HttpStatus.OK);}
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}

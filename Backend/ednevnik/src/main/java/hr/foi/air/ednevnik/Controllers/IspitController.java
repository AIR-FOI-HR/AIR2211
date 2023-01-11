package hr.foi.air.ednevnik.Controllers;

import hr.foi.air.ednevnik.Entities.DnevnaAktivnost;
import hr.foi.air.ednevnik.Entities.Ispit;
import hr.foi.air.ednevnik.Services.IspitService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/ispiti")
public class IspitController {

    IspitService ispitService;

    @GetMapping("/getById/{id}")
    public ResponseEntity<Optional<Ispit>> GetAktivnostById(@PathVariable int id){
        var ispit = ispitService.IspitById(id);
        try{
            if(ispit.isEmpty()){
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            else
                return new ResponseEntity<>(ispit, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAllBySpecijalizacijaId/{specijalizacija_id}")
    public ResponseEntity<List<Ispit>> GetIspitiBySpecijalizacija(@PathVariable int specijalizacija_id){
        var ispiti = ispitService.IspitiBySpecijalizacija(specijalizacija_id);
        try{
            if(ispiti.isEmpty()){
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            else
                return new ResponseEntity<>(ispiti, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping("/add")
    @ResponseBody
    public ResponseEntity<Ispit> AddIspit(@RequestBody Ispit ispit){
        try{
            ispitService.AddIspit(ispit);
            return new ResponseEntity<>(ispit, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> DeleteIspit(@PathVariable int id){
        try{
            Long odgovor = ispitService.DeleteIspit(id);
            if(odgovor==0L) {return new ResponseEntity<>(odgovor, HttpStatus.BAD_REQUEST);}
            else {return new ResponseEntity<>(odgovor, HttpStatus.OK);}
        }catch (Exception e){
            return new ResponseEntity<>(0L, HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping("/update")
    @ResponseBody
    public ResponseEntity<Ispit> UpdateIspit(@RequestBody Ispit ispit){
        try{
            Ispit odgovor = ispitService.UpdateIspit(ispit);
            if(odgovor==null) {return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);}
            else {return new ResponseEntity<>(ispit, HttpStatus.OK);}
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}

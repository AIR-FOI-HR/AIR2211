package hr.foi.air.ednevnik.Controllers;

import hr.foi.air.ednevnik.Services.DioSpecijalizacijeService;
import hr.foi.air.ednevnik.Services.ProgramSpecijalizacijeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/programi_specijalizacije")
public class ProgramSpecijalizacijeController {

    ProgramSpecijalizacijeService programSpecijalizacijeService;

    @GetMapping("/getCountRequirementsById/{program_specijalizacije_id}")
    public ResponseEntity<Integer> GetBrojUvjetaById(@PathVariable int program_specijalizacije_id){
        var brojUvjeta = programSpecijalizacijeService.BrojUvjetaById(program_specijalizacije_id);
        try{
            if(brojUvjeta==null){
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            else
                return new ResponseEntity<>(brojUvjeta, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}

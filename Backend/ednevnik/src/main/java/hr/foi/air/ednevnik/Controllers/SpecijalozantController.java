package hr.foi.air.ednevnik.Controllers;

import hr.foi.air.ednevnik.Entities.Specijalizant;
import hr.foi.air.ednevnik.Services.SpecijalizantService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.swing.text.html.HTML;
import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/specijalizanti")
public class SpecijalozantController {
    private SpecijalizantService specijalizantService;

    @GetMapping("/get")
    public ResponseEntity<List<Specijalizant>> GetJobs(@RequestParam List<String> categories){
        var specijalizanti = specijalizantService.sviSpecijalizanti();
        try{
            if(specijalizanti==null){
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            else
                return new ResponseEntity<>(specijalizanti, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}

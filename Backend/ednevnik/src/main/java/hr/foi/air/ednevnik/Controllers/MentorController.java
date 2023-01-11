package hr.foi.air.ednevnik.Controllers;

import hr.foi.air.ednevnik.Entities.Mentor;
import hr.foi.air.ednevnik.Entities.ProvjeraZnanja;
import hr.foi.air.ednevnik.Services.MentorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/mentori")
public class MentorController {

    MentorService mentorService;

    @GetMapping("/getById/{id}")
    public ResponseEntity<Optional<Mentor>> GetMentorById(@PathVariable int id){
        var mentor = mentorService.MentorById(id);
        try{
            if(mentor.isEmpty()){
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            else
                return new ResponseEntity<>(mentor, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}

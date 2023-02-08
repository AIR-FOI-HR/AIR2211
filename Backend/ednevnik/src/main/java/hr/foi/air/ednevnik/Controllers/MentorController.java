package hr.foi.air.ednevnik.Controllers;

import hr.foi.air.ednevnik.Entities.Mentor;
import hr.foi.air.ednevnik.Requests.PrijavaRequest;
import hr.foi.air.ednevnik.Services.MentorService;
import hr.foi.air.ednevnik.Services.PrijavaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/mentori")
public class MentorController {

    MentorService mentorService;
    PrijavaService prijavaService;

    @GetMapping("/getById/{id}")
    public ResponseEntity<Optional<Mentor>> GetMentorById(@PathVariable int id) {
        var mentor = mentorService.MentorById(id);
        try {
            if (mentor.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            } else return new ResponseEntity<>(mentor, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAllByUstrojstvenaJedinica/{ustrojstvena_jedinica}")
    public ResponseEntity<List<Mentor>> GetStrucniRadoviBySpecijalizacija(@PathVariable int ustrojstvena_jedinica) {
        var mentori = mentorService.MentoriByUstrojstvenaJedinica(ustrojstvena_jedinica);
        try {
            if (mentori.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            } else return new ResponseEntity<>(mentori, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/prijava")
    public ResponseEntity<Mentor> prijava(@RequestBody PrijavaRequest request) throws Exception {
        Mentor mentor = prijavaService.prijavaMentora(request);
        try {
            if (mentor != null) {
                return new ResponseEntity<>(mentor, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}

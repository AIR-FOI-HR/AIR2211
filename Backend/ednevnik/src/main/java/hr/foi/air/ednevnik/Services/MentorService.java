package hr.foi.air.ednevnik.Services;

import hr.foi.air.ednevnik.Entities.Mentor;
import hr.foi.air.ednevnik.Entities.ProvjeraZnanja;
import hr.foi.air.ednevnik.Repositories.MentorRepository;
import hr.foi.air.ednevnik.Repositories.ProvjeraZnanjaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class MentorService {
    MentorRepository mentorRepository;

    public Optional<Mentor> MentorById(int id){
        Optional<Mentor> mentor = mentorRepository.findByIdMentor(id);
        return mentor;
    }

}

package hr.foi.air.ednevnik.Services;

import hr.foi.air.ednevnik.Entities.Mentor;
import hr.foi.air.ednevnik.Repositories.MentorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MentorService {
    MentorRepository mentorRepository;

    public Optional<Mentor> MentorById(int id){
        Optional<Mentor> mentor = mentorRepository.findByIdMentor(id);
        return mentor;
    }

    public List<Mentor> MentoriByUstrojstvenaJedinica(int ustrojstvenaJedinica){
        List<Mentor> mentori = new ArrayList<>();
        mentori.addAll(mentorRepository.findAllByUstrojstvenaJedinica(ustrojstvenaJedinica));
        return mentori;
    }

}

package hr.foi.air.ednevnik.Services;

import hr.foi.air.ednevnik.Entities.Specijalizant;
import hr.foi.air.ednevnik.Repositories.MentorRepository;
import hr.foi.air.ednevnik.Repositories.SpecijalizacijaRepository;
import hr.foi.air.ednevnik.Repositories.SpecijalizantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SpecijalizantService {

    private final SpecijalizantRepository specijalizantRepository;

    public List<Specijalizant> SviSpecijalizanti(){

        List<Specijalizant> specijalizanti = new ArrayList<>();
        specijalizanti.addAll(specijalizantRepository.findAll());
        return specijalizanti;
    }

    public Optional<Specijalizant> SpecijalizantById(int id){
        Optional<Specijalizant> specijalizant = specijalizantRepository.findAllByIdSpecijalizant(id);
        return specijalizant;
    }
    public List<Specijalizant> SpecijalizantiByMentor(int idMentor) {
        return specijalizantRepository.findAllSpecijalizantiByMentorId(idMentor);
    }

}

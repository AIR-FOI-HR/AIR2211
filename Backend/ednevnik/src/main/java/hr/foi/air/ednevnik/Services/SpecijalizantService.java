package hr.foi.air.ednevnik.Services;

import hr.foi.air.ednevnik.Entities.Specijalizant;
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

    public List<Specijalizant> sviSpecijalizanti(){

        List<Specijalizant> specijalizanti = new ArrayList<>();

        specijalizanti.addAll(specijalizantRepository.findAll());
        System.out.print(specijalizanti);

        return specijalizanti;
    }

    public Optional<Specijalizant> specijalizantById(int id){
        Optional<Specijalizant> specijalizant = specijalizantRepository.findAllByIdSpecijalizant(id);
        return specijalizant;
    }

}

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

    public List<Specijalizant> SviSpecijalizanti(){

        List<Specijalizant> specijalizanti = new ArrayList<>();
        specijalizanti.addAll(specijalizantRepository.findAll());
        return specijalizanti;
    }

    public Optional<Specijalizant> SpecijalizantById(int id){
        Optional<Specijalizant> specijalizant = specijalizantRepository.findAllByIdSpecijalizant(id);
        return specijalizant;
    }

    public Specijalizant AddSpecijalizant(Specijalizant specijalizant) { return specijalizantRepository.save(specijalizant); }

    public Long DeleteSpecijalizant(int id) {
        if(specijalizantRepository.existsById(id)) { return specijalizantRepository.deleteByIdSpecijalizant(id); }
        else { return 0L; }
    }

    public Specijalizant UpdateSpecijalizant(Specijalizant updateSpecijalizant) {
        Optional<Specijalizant> specijalizantZaUpdate = SpecijalizantById(updateSpecijalizant.getIdSpecijalizant());
        if(specijalizantZaUpdate.isEmpty()) { return null; }
        else { return specijalizantRepository.save(updateSpecijalizant); }
    }

}

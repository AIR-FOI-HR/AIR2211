package hr.foi.air.ednevnik.Services;

import hr.foi.air.ednevnik.Entities.SlucajBolesnika;
import hr.foi.air.ednevnik.Entities.Specijalizant;
import hr.foi.air.ednevnik.Entities.StrucniRad;
import hr.foi.air.ednevnik.Repositories.SlucajBolesnikaRepository;
import hr.foi.air.ednevnik.Repositories.SpecijalizantRepository;
import hr.foi.air.ednevnik.Repositories.StrucniRadRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SlucajBolesnikaService {

    private final SlucajBolesnikaRepository slucajBolesnikaRepository;

    public List<SlucajBolesnika> SlucajeviBolesnikaBySpecijalizacija(int id){

        List<SlucajBolesnika> slucajevi_bolesnika = new ArrayList<>();
        slucajevi_bolesnika.addAll(slucajBolesnikaRepository.findAllBySpecijalizacija(id));
        return slucajevi_bolesnika;
    }

    public Optional<SlucajBolesnika> SlucajBolesnikaById(int id){
        Optional<SlucajBolesnika> strucniRad = slucajBolesnikaRepository.findByIdSlucaj(id);
        return strucniRad;
    }

}

package hr.foi.air.ednevnik.Services;

import hr.foi.air.ednevnik.Entities.Specijalizacija;
import hr.foi.air.ednevnik.Entities.Specijalizant;
import hr.foi.air.ednevnik.Repositories.SpecijalizacijaRepository;
import hr.foi.air.ednevnik.Repositories.SpecijalizantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SpecijalizacijaService {

    private final SpecijalizacijaRepository specijalizacijaRepository;

    public List<Specijalizacija> sveSpecijalizacijeBySpecijalizantId(int id){

        List<Specijalizacija> specijalizacije = new ArrayList<>();

        specijalizacije.addAll(specijalizacijaRepository.findAllBySpecijalizant(id));
        System.out.print(specijalizacije);

        return specijalizacije;
    }

    public Optional<Specijalizacija> aktivnaSpecijalizacijaBySpecijalizantId(int id){
        Optional<Specijalizacija> specijalizacija = specijalizacijaRepository.findBySpecijalizantAndDatumZavrsetkaIsNull(id);
        return specijalizacija;
    }

    public Optional<Specijalizacija> specijalizacijaById(int id){
        Optional<Specijalizacija> specijalizacija = specijalizacijaRepository.findByIdSpecijalizacija(id);
        return specijalizacija;
    }

}

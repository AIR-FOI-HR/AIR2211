package hr.foi.air.ednevnik.Services;

import hr.foi.air.ednevnik.Entities.Specijalizacija;
import hr.foi.air.ednevnik.Repositories.SpecijalizacijaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SpecijalizacijaService {

    private final SpecijalizacijaRepository specijalizacijaRepository;

    public List<Specijalizacija> SpecijalizacijeBySpecijalizantId(int id){
        List<Specijalizacija> specijalizacije = new ArrayList<>();
        specijalizacije.addAll(specijalizacijaRepository.findAllBySpecijalizant(id));
        return specijalizacije;
    }

    public Optional<Specijalizacija> AktivnaSpecijalizacijaBySpecijalizantId(int id){
        Optional<Specijalizacija> specijalizacija = specijalizacijaRepository.findBySpecijalizantAndDatumZavrsetkaIsNull(id);
        return specijalizacija;
    }

    public Optional<Specijalizacija> SpecijalizacijaById(int id){
        Optional<Specijalizacija> specijalizacija = specijalizacijaRepository.findByIdSpecijalizacija(id);
        return specijalizacija;
    }

}

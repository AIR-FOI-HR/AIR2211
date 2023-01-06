package hr.foi.air.ednevnik.Services;

import hr.foi.air.ednevnik.Entities.*;
import hr.foi.air.ednevnik.Repositories.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PitanjeService {

    private final PitanjeRepository pitanjeRepository;

    public List<Pitanje> PitanjaByProvjeraZnanja(int id){

        List<Pitanje> pitanja = new ArrayList<>();
        pitanja.addAll(pitanjeRepository.findAllByProvjera(id));
        return pitanja;
    }

    public Optional<Pitanje> ProvjeraZnanjaById(int id){
        Optional<Pitanje> pitanje = pitanjeRepository.findByIdPitanje(id);
        return pitanje;
    }

}

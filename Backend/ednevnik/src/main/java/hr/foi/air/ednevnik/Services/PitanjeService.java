package hr.foi.air.ednevnik.Services;

import hr.foi.air.ednevnik.Entities.Pitanje;
import hr.foi.air.ednevnik.Repositories.PitanjeRepository;
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

    public Optional<Pitanje> PitanjeById(int id){
        Optional<Pitanje> pitanje = pitanjeRepository.findByIdPitanje(id);
        return pitanje;
    }

    public Pitanje AddPitanje(Pitanje strucniRad) {
        return pitanjeRepository.save(strucniRad);
    }

    public Long DeletePitanje(int id) {
        if(pitanjeRepository.existsById(id)) { return pitanjeRepository.deleteByIdPitanje(id); }
        else { return 0L; }
    }

    public Pitanje UpdatePitanje(Pitanje updatedPitanje) {
        Optional<Pitanje> pitanjeZaUpdate = PitanjeById(updatedPitanje.getIdPitanje());
        if(pitanjeZaUpdate.isEmpty()) { return null; }
        else { return pitanjeRepository.save(updatedPitanje); }
    }

}

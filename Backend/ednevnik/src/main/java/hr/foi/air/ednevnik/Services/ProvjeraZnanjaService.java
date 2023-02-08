package hr.foi.air.ednevnik.Services;

import hr.foi.air.ednevnik.Entities.ProvjeraZnanja;
import hr.foi.air.ednevnik.Repositories.ProvjeraZnanjaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProvjeraZnanjaService {

    private final ProvjeraZnanjaRepository provjeraZnanjaRepository;

    public List<ProvjeraZnanja> ProvjereZnanjaBySpecijalizacija(int id) {

        List<ProvjeraZnanja> provjereZnanja = new ArrayList<>();
        provjereZnanja.addAll(provjeraZnanjaRepository.findAllBySpecijalizacija(id));
        return provjereZnanja;
    }

    public Optional<ProvjeraZnanja> ProvjeraZnanjaById(int id) {
        Optional<ProvjeraZnanja> provjeraZnanja = provjeraZnanjaRepository.findByIdProvjera(id);
        return provjeraZnanja;
    }

    public ProvjeraZnanja AddProvjeraZnanja(ProvjeraZnanja provjeraZnanja) {
        return provjeraZnanjaRepository.save(provjeraZnanja);
    }

    public Long DeleteProvjeraZnanja(int id) {
        if (provjeraZnanjaRepository.existsById(id)) {
            return provjeraZnanjaRepository.deleteByIdProvjera(id);
        } else {
            return 0L;
        }
    }

    public ProvjeraZnanja UpdateProvjeraZnanja(ProvjeraZnanja updatedProvjeraZnanja) {
        Optional<ProvjeraZnanja> provjeraZnanjaZaUpdate = ProvjeraZnanjaById(updatedProvjeraZnanja.getIdProvjera());
        if (provjeraZnanjaZaUpdate.isEmpty()) {
            return null;
        } else {
            return provjeraZnanjaRepository.save(updatedProvjeraZnanja);
        }
    }
}

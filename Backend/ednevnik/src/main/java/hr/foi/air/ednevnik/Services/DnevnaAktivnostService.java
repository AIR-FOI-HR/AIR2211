package hr.foi.air.ednevnik.Services;

import hr.foi.air.ednevnik.Entities.DnevnaAktivnost;
import hr.foi.air.ednevnik.Entities.StrucniRad;
import hr.foi.air.ednevnik.Repositories.DnevnaAktivnostRepository;
import hr.foi.air.ednevnik.Repositories.StrucniRadRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DnevnaAktivnostService {
    private final DnevnaAktivnostRepository dnevnaAktivnostRepository;

    public List<DnevnaAktivnost> DnevneAktivnostiBySpecijalizacija(int id){

        List<DnevnaAktivnost> dnevneAktivnosti = new ArrayList<>();
        dnevneAktivnosti.addAll(dnevnaAktivnostRepository.findAllBySpecijalizacija(id));
        return dnevneAktivnosti;
    }

    public Optional<DnevnaAktivnost> DnevnaAktivnostById(int id){
        Optional<DnevnaAktivnost> dnevnaAktivnost = dnevnaAktivnostRepository.findByIdAktivnost(id);
        return dnevnaAktivnost;
    }
}

package hr.foi.air.ednevnik.Services;

import hr.foi.air.ednevnik.Entities.StupanjNapredovanja;
import hr.foi.air.ednevnik.Repositories.StupanjNapredovanjaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class StupanjNapredovanjaService {

    private final StupanjNapredovanjaRepository stupanjNapredovanjaRepository;

    public Optional<StupanjNapredovanja> StupanjNapredovanjaById(int id){
        Optional<StupanjNapredovanja> stupanjNapredovanja = stupanjNapredovanjaRepository.findByIdStupanj(id);
        return stupanjNapredovanja;
    }
}

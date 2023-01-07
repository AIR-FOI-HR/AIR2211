package hr.foi.air.ednevnik.Services;

import hr.foi.air.ednevnik.Entities.SlucajBolesnika;
import hr.foi.air.ednevnik.Repositories.SlucajBolesnikaRepository;
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

        List<SlucajBolesnika> slucajeviBolesnika = new ArrayList<>();
        slucajeviBolesnika.addAll(slucajBolesnikaRepository.findAllBySpecijalizacija(id));
        return slucajeviBolesnika;
    }

    public Optional<SlucajBolesnika> SlucajBolesnikaById(int id){
        Optional<SlucajBolesnika> slucajBolesnika = slucajBolesnikaRepository.findByIdSlucaj(id);
        return slucajBolesnika;
    }

    public SlucajBolesnika AddSlucajBolesnika(SlucajBolesnika slucajBolesnika) { return slucajBolesnikaRepository.save(slucajBolesnika); }

    public Long DeleteSlucajBolesnika(int id) {
        if(slucajBolesnikaRepository.existsById(id)) { return slucajBolesnikaRepository.deleteByIdSlucaj(id); }
        else { return 0L; }
    }

    public SlucajBolesnika UpdateSlucajBolesnika(SlucajBolesnika updatedSlucajBolesnika) {
        Optional<SlucajBolesnika> slucajBolesnikaZaUpdate = SlucajBolesnikaById(updatedSlucajBolesnika.getIdSlucaj());
        if(slucajBolesnikaZaUpdate.isEmpty()) { return null; }
        else { return slucajBolesnikaRepository.save(updatedSlucajBolesnika); }
    }

}

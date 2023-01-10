package hr.foi.air.ednevnik.Services;

import hr.foi.air.ednevnik.Entities.UstrojstvenaJedinica;
import hr.foi.air.ednevnik.Repositories.UstrojstvenaJedinicaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UstrojstvenaJedinicaService {

    private UstrojstvenaJedinicaRepository ustrojstvenaJedinicaRepository;

    public Optional<UstrojstvenaJedinica> UstrojstvenaJedinicaById(int id){
        Optional<UstrojstvenaJedinica> ustrojstvenaJedinica = ustrojstvenaJedinicaRepository.findByIdJedinica(id);
        return ustrojstvenaJedinica;
    }
}

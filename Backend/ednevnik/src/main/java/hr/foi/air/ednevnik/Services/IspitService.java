package hr.foi.air.ednevnik.Services;

import hr.foi.air.ednevnik.Entities.Ispit;
import hr.foi.air.ednevnik.Repositories.IspitRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class IspitService {

    IspitRepository ispitRepository;

    public Optional<Ispit> IspitById(int id) {
        Optional<Ispit> ispit = ispitRepository.findByIdIspit(id);
        return ispit;
    }

    public List<Ispit> IspitiBySpecijalizacija(int id) {
        List<Ispit> ispiti = new ArrayList<>();
        ispiti.addAll(ispitRepository.findAllBySpecijalizacija(id));
        return ispiti;
    }

    public List<Ispit> NadolazeciIspitiBySpecijalizacija(int id) {
        List<Ispit> ispiti = new ArrayList<>();
        Date datum = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:SS");
        Time vrijeme = new Time(System.currentTimeMillis());
        ispiti.addAll(ispitRepository.findNadolazeciIspitiBySpecijalizacija(id, datum, vrijeme));
        return ispiti;
    }

    public Ispit AddIspit(Ispit ispit) {
        return ispitRepository.save(ispit);
    }

    public Long DeleteIspit(int id) {
        if (ispitRepository.existsById(id)) {
            return ispitRepository.deleteByIdIspit(id);
        } else {
            return 0L;
        }
    }

    public Ispit UpdateIspit(Ispit updatedIspit) {
        Optional<Ispit> ispitZaUpdate = IspitById(updatedIspit.getIdIspit());
        if (ispitZaUpdate.isEmpty()) {
            return null;
        } else {
            return ispitRepository.save(updatedIspit);
        }
    }
}

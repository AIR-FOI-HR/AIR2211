package hr.foi.air.ednevnik.Services;

import hr.foi.air.ednevnik.Entities.OdradeniZahvat;
import hr.foi.air.ednevnik.Repositories.OdradeniZahvatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OdradeniZahvatService {

    private final OdradeniZahvatRepository odradeniZahvatRepository;

    public List<OdradeniZahvat> OdradeniZahvatiBySpecijalizacija(int specijalizacija) {
        return odradeniZahvatRepository.findAllBySpecijalizacija(specijalizacija);
    }

    public Optional<OdradeniZahvat> OdradeniZahvatByIds(int specijalizacija, int zahvat, int stupanj) {
        Optional<OdradeniZahvat> odradeniZahvat = odradeniZahvatRepository.findBySpecijalizacijaAndZahvatAndStupanj(specijalizacija, zahvat, stupanj);
        return odradeniZahvat;
    }

    public OdradeniZahvat AddOdradeniZahvat(OdradeniZahvat odradeniZahvat) {
        return odradeniZahvatRepository.save(odradeniZahvat);
    }

    public Long DeleteOdradeniZahvat(int specijalizacija, int zahvat, int stupanj) {
        if (OdradeniZahvatByIds(specijalizacija, zahvat, stupanj) != null) {
            return odradeniZahvatRepository.deleteBySpecijalizacijaAndZahvatAndStupanj(specijalizacija, zahvat, stupanj);
        } else {
            return 0L;
        }
    }

    public OdradeniZahvat UpdateOdradeniZahvat(OdradeniZahvat updatedOdradeniZahvat) {
        Optional<OdradeniZahvat> odradeniZahvatZaUpdate = OdradeniZahvatByIds(updatedOdradeniZahvat.getSpecijalizacija(), updatedOdradeniZahvat.getZahvat(), updatedOdradeniZahvat.getStupanj());
        if (odradeniZahvatZaUpdate.isEmpty()) {
            return null;
        } else {
            return odradeniZahvatRepository.save(updatedOdradeniZahvat);
        }
    }
}

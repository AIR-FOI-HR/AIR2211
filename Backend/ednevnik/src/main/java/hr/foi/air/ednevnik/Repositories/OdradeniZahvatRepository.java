package hr.foi.air.ednevnik.Repositories;

import hr.foi.air.ednevnik.Entities.OdradeniZahvat;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface OdradeniZahvatRepository extends JpaRepository<OdradeniZahvat, Integer> {
    List<OdradeniZahvat> findAllBySpecijalizacija(int id);

    Optional<OdradeniZahvat> findBySpecijalizacijaAndZahvatAndStupanj(int specijalizacija, int zahvat, int stupanj);

    @Transactional
    Long deleteBySpecijalizacijaAndZahvatAndStupanj(int specijalizacija, int zahvat, int stupanj);
}
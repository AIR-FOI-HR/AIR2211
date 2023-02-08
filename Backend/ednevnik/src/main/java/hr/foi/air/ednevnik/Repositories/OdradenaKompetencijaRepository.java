package hr.foi.air.ednevnik.Repositories;

import hr.foi.air.ednevnik.Entities.OdradenaKompetencija;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface OdradenaKompetencijaRepository extends JpaRepository<OdradenaKompetencija, Integer> {

    List<OdradenaKompetencija> findAllBySpecijalizacija(int id);

    Optional<OdradenaKompetencija> findBySpecijalizacijaAndKompetencijaAndStupanj(int specijalizacija, int kompetencija, int stupanj);

    @Transactional
    Long deleteBySpecijalizacijaAndKompetencijaAndStupanj(int specijalizacija, int kompetencija, int stupanj);
}
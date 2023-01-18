package hr.foi.air.ednevnik.Repositories;

import hr.foi.air.ednevnik.Entities.Kompetencija;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface KompetencijaRepository extends JpaRepository<Kompetencija, Integer> {

    List<Kompetencija> findAllByProgramSpecijalizacije(int id);

    Integer countAllByProgramSpecijalizacije(int id);

    Optional<Kompetencija> findByIdKompetencija(int id);
}

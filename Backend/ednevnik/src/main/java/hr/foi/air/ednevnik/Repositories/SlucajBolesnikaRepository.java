package hr.foi.air.ednevnik.Repositories;

import hr.foi.air.ednevnik.Entities.SlucajBolesnika;
import hr.foi.air.ednevnik.Entities.StrucniRad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SlucajBolesnikaRepository extends JpaRepository<SlucajBolesnika, Integer> {

    List<SlucajBolesnika> findAllBySpecijalizacija(int id);

    Optional<SlucajBolesnika> findByIdSlucaj(int id);

}

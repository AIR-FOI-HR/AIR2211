package hr.foi.air.ednevnik.Repositories;

import hr.foi.air.ednevnik.Entities.Zahvat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ZahvatRepository extends JpaRepository<Zahvat, Integer> {
    List<Zahvat> findAllByProgramSpecijalizacije(int id);

    Integer countAllByProgramSpecijalizacije(int id);

    Optional<Zahvat> findByIdZahvat(int id);
}
package hr.foi.air.ednevnik.Repositories;

import hr.foi.air.ednevnik.Entities.Zahvat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ZahvatRepository extends JpaRepository<Zahvat, Integer> {
    List<Zahvat> findAllByProgramSpecijalizacije(int id);

    Integer countAllByProgramSpecijalizacije(int id);
}
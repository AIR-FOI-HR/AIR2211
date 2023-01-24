package hr.foi.air.ednevnik.Repositories;

import hr.foi.air.ednevnik.Entities.DioSpecijalizacije;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DioSpecijalizacijeRepository extends JpaRepository<DioSpecijalizacije, Integer> {

    List<DioSpecijalizacije> findAllByProgramSpecijalizacije(int id);

    Integer countAllByProgramSpecijalizacije(int id);

    Optional<DioSpecijalizacije> findByIdDioSpecjalizacije(int id);
}
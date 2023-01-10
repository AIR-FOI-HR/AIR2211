package hr.foi.air.ednevnik.Repositories;

import hr.foi.air.ednevnik.Entities.DioSpecijalizacije;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DioSpecijalizacijeRepository extends JpaRepository<DioSpecijalizacije, Integer> {

    List<DioSpecijalizacije> findAllByProgramSpecijalizacije(int id);
}

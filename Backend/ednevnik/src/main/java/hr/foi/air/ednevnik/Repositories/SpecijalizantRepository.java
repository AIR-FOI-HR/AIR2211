package hr.foi.air.ednevnik.Repositories;

import hr.foi.air.ednevnik.Entities.Specijalizant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpecijalizantRepository extends JpaRepository<Specijalizant, Long> {
    List<Specijalizant> findAll();
}

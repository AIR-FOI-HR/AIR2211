package hr.foi.air.ednevnik.Repositories;

import hr.foi.air.ednevnik.Entities.Specijalizant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpecijalizantRepository extends JpaRepository<Specijalizant, Integer> {
    List<Specijalizant> findAll();

    Optional<Specijalizant> findAllByIdSpecijalizant(int id);

}

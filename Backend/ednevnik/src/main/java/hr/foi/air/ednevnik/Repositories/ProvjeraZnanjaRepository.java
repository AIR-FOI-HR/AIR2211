package hr.foi.air.ednevnik.Repositories;

import hr.foi.air.ednevnik.Entities.ProvjeraZnanja;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface ProvjeraZnanjaRepository extends JpaRepository<ProvjeraZnanja, Integer> {
    List<ProvjeraZnanja> findAllBySpecijalizacija(int id);

    Optional<ProvjeraZnanja> findByIdProvjera(int id);

    @Transactional
    Long deleteByIdProvjera(int id);
}

package hr.foi.air.ednevnik.Repositories;

import hr.foi.air.ednevnik.Entities.Pitanje;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PitanjeRepository extends JpaRepository<Pitanje, Integer> {
    List<Pitanje> findAllByProvjera(int id);

    Optional<Pitanje> findByIdPitanje(int id);
}

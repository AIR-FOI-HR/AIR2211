package hr.foi.air.ednevnik.Repositories;

import hr.foi.air.ednevnik.Entities.UstrojstvenaJedinica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UstrojstvenaJedinicaRepository extends JpaRepository<UstrojstvenaJedinica, Integer> {

    Optional<UstrojstvenaJedinica> findByIdJedinica(int id);
}
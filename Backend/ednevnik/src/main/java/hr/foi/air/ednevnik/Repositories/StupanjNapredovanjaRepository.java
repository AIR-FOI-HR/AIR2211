package hr.foi.air.ednevnik.Repositories;

import hr.foi.air.ednevnik.Entities.StupanjNapredovanja;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StupanjNapredovanjaRepository extends JpaRepository<StupanjNapredovanja, Integer> {

    Optional<StupanjNapredovanja> findByIdStupanj(int id);
}
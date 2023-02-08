package hr.foi.air.ednevnik.Repositories;

import hr.foi.air.ednevnik.Entities.DnevnaAktivnost;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface DnevnaAktivnostRepository extends JpaRepository<DnevnaAktivnost, Integer> {

    List<DnevnaAktivnost> findAllBySpecijalizacija(int id);

    Optional<DnevnaAktivnost> findByIdAktivnost(int id);

    @Transactional
    Long deleteByIdAktivnost(int id);
}
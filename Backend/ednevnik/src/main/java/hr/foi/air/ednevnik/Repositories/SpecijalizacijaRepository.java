package hr.foi.air.ednevnik.Repositories;

import hr.foi.air.ednevnik.Entities.Specijalizacija;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface SpecijalizacijaRepository extends JpaRepository<Specijalizacija, Integer> {
    List<Specijalizacija> findAllBySpecijalizant(int id);

    Optional<Specijalizacija> findBySpecijalizantAndDatumZavrsetkaIsNull(int id);

    Optional<Specijalizacija> findByIdSpecijalizacija(int id);

    @Transactional
    Long deleteByIdSpecijalizacija(int id);

}

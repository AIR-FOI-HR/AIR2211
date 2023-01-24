package hr.foi.air.ednevnik.Repositories;

import hr.foi.air.ednevnik.Entities.SlucajBolesnika;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface SlucajBolesnikaRepository extends JpaRepository<SlucajBolesnika, Integer> {

    List<SlucajBolesnika> findAllBySpecijalizacija(int id);

    Optional<SlucajBolesnika> findByIdSlucaj(int id);

    @Transactional
    Long deleteByIdSlucaj(int id);
}
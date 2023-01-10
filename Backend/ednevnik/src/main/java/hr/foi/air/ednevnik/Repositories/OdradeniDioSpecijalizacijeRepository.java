package hr.foi.air.ednevnik.Repositories;

import hr.foi.air.ednevnik.Entities.OdradeniDioSpecijalizacije;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface OdradeniDioSpecijalizacijeRepository extends JpaRepository<OdradeniDioSpecijalizacije, Integer>  {

    List<OdradeniDioSpecijalizacije> findAllBySpecijalizacija(int id);

    Optional<OdradeniDioSpecijalizacije> findBySpecijalizacijaAndAndDioSpecijalizacije(int specijalizacija, int dioSpecijalizacije);

    @Transactional
    Long deleteBySpecijalizacijaAndDioSpecijalizacije(int specijalizacija, int dioSpecijalizacije);
}

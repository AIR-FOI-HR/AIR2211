package hr.foi.air.ednevnik.Repositories;

import hr.foi.air.ednevnik.Entities.StrucniRad;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface StrucniRadRepository extends JpaRepository<StrucniRad, Integer> {

    List<StrucniRad> findAllBySpecijalizacija(int id);

    Optional<StrucniRad> findByIdRad(int id);

    @Transactional
    Long deleteByIdRad(int id);



}

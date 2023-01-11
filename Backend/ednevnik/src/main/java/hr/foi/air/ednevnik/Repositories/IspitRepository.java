package hr.foi.air.ednevnik.Repositories;

import hr.foi.air.ednevnik.Entities.Ispit;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface IspitRepository extends JpaRepository<Ispit, Integer> {

    Optional<Ispit> findByIdIspit(int id);

    List<Ispit> findAllBySpecijalizacija(int id);

    @Transactional
    Long deleteByIdIspit(int id);
}

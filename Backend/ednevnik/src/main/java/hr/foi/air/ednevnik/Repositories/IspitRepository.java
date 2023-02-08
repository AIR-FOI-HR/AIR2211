package hr.foi.air.ednevnik.Repositories;

import hr.foi.air.ednevnik.Entities.Ispit;
import hr.foi.air.ednevnik.Entities.Specijalizant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IspitRepository extends JpaRepository<Ispit, Integer> {

    Optional<Ispit> findByIdIspit(int id);

    List<Ispit> findAllBySpecijalizacija(int id);

    @Query(value = "SELECT i FROM Ispit i WHERE i.specijalizacija = :id AND ((i.datum > :datum) OR (i.datum = :datum AND i.vrijemeOdrzavanja > :vrijeme))")
    List<Ispit> findNadolazeciIspitiBySpecijalizacija(@Param("id") int id, @Param("datum") Date datum, @Param("vrijeme") Time vrijeme);

    @Transactional
    Long deleteByIdIspit(int id);
}